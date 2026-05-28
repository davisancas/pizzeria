package com.example.demo.features.api.ingredients.queries;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.features.core.infraestructure.LookupResolver;
import com.example.demo.features.domain.ingredients.Ingredient;

public class GetIngredient {
    @RestController
    @RequestMapping("/api/ingredient")
    public static class Endpoint {
       
        private final Servicio servicio;
 
        public Endpoint(Servicio servicio) {
            this.servicio = servicio;
        }
 
        @GetMapping("/{id}")
        public ResponseEntity<?> find(@PathVariable("id") UUID id) {
            return ResponseEntity.ok(servicio.getIngredient(id));
        }
    }
 
    public interface Servicio {
        Response getIngredient(UUID id);
    }

    @Service
    public static class ServicioImpl implements Servicio {
        private final LookupResolver lookup;
 
        public ServicioImpl(LookupResolver lookup) {
            this.lookup = lookup;
        }
 
        public Response getIngredient(UUID id) {
            var ingredient = lookup.find(Ingredient.class, id);
            return new Response(ingredient.getId(), ingredient.getName(), ingredient.getCost());
        }
    }
 
    public record Response(UUID id, String name, BigDecimal cost){}
}
