package com.example.demo.features.infraestructure.pizza;

import java.util.Set;
import java.util.UUID;
import static java.util.stream.Collectors.toSet;

import org.springframework.stereotype.Component;

import com.example.demo.features.core.infraestructure.Mapper;
import com.example.demo.features.domain.ingredients.Ingredient;
import com.example.demo.features.domain.pizza.Pizza;
import com.example.demo.features.infraestructure.ingredient.IngredientMapper;

@Component
public class PizzaMapper implements Mapper<Pizza, PizzaJpa>{
private final IngredientMapper ingredientMapper;

    private static class PizzaMap extends Pizza{
        public PizzaMap(UUID id, String name, String description, String url, Set<Ingredient> ingredients){
            super(id, name, description, url, ingredients);
        }
    }
    public PizzaMapper(IngredientMapper ingredientMapper) {
        this.ingredientMapper = ingredientMapper;
    }

    public PizzaJpa toJpa(Pizza pizza) {
        var ingredients = pizza.getIngredients().stream()
            .map(ingredientMapper::toJpa)
            .collect(toSet());

        return new PizzaJpa(
            pizza.getId(),
            pizza.getName(),
            pizza.getDescription(),
            pizza.getUrl(),
            ingredients
        );
    }

    public Pizza toDomain(PizzaJpa jpa) {
        var ingredients = jpa.getIngredients().stream()
            .map(ingredientMapper::toDomain)
            .collect(toSet());

        return new PizzaMap(
            jpa.getId(),
            jpa.getName(),
            jpa.getDescription(),
            jpa.getUrl(),
            ingredients
        );
    }
}
