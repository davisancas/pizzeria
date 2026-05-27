package com.example.demo.features.api.ingredients.commands;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.features.domain.ingredients.Ingredient;
import com.example.demo.features.domain.ingredients.IngredientRepository;

public class IngredientCreate {

    @RestController
    @RequestMapping("/api/ingredient")
    public static class Endpoint {

        private final Servicio servicio;

        public Endpoint(Servicio servicio) {
            this.servicio = servicio;
        }

        @PostMapping
        public ResponseEntity<?> create(@RequestBody Request request) {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addIngredient(request));
        }
    }

    public interface Servicio {
        Response addIngredient(Request request);
    }

    @Service
    public static class ServicioImpl implements Servicio {
        
        private final IngredientRepository repository;

        public ServicioImpl(IngredientRepository repository) {
            this.repository = repository;
        }

        @Override
        public Response addIngredient(Request request) {
            Ingredient ingredient = new Ingredient(UUID.randomUUID(), request.name, request.cost);
            Ingredient saved = repository.save(ingredient);
            return new Response(saved.getId(), saved.getName(), saved.getCost());
        }
    }

    public record Request(String name, BigDecimal cost) { }

    public record Response(UUID id, String name, BigDecimal cost) { }
}
