package com.example.demo.features.api.pizza;

import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.features.core.infraestructure.IAddJpa;
import com.example.demo.features.core.infraestructure.LookupResolver;
import com.example.demo.features.domain.ingredients.Ingredient;
import com.example.demo.features.domain.pizza.Pizza;
import com.example.demo.features.infraestructure.pizza.PizzaJpa;

public class PizzaCreate {

    @RestController
    @RequestMapping("/api/pizzas")
    public static class Endpoint {

        private final Servicio servicio;

        public Endpoint(Servicio servicio) {
            this.servicio = servicio;
        }

        @PostMapping
        public ResponseEntity<?> create(@RequestBody Request request) {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addPizza(request));
        }
    }

    public interface Servicio {
        Response addPizza(Request request);
    }

    @Service
    public static class ServicioImpl implements Servicio {
        private final IAddJpa<Pizza, UUID, PizzaJpa> repository;
        private final LookupResolver lookup;

        public ServicioImpl(IAddJpa<Pizza, UUID, PizzaJpa> repository, LookupResolver lookup) {
            this.repository = repository;
            this.lookup = lookup;
        }

        @Override
        public Response addPizza(Request request) {
            var ingredients = lookup.findAll(Ingredient.class, request.ingredientIds());

            var pizza = Pizza.create(
                UUID.randomUUID(),
                request.name(),
                request.description(),
                request.url(),
                ingredients
            );

            repository.add(pizza);
            return new Response(pizza.getId());
        }
    }

    public record Request(
        String name,
        String description,
        String url,
        Set<UUID> ingredientIds
    ) { }

    public record Response(UUID id) { }
}
