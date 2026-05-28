package com.example.demo.features.infraestructure.ingredient;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.demo.features.core.infraestructure.Mapper;
import com.example.demo.features.domain.ingredients.Ingredient;

@Component
public class IngredientMapper implements Mapper<Ingredient, IngredientJpa>{

    private static class IngredientMap extends Ingredient{
        public IngredientMap(UUID id, String name, BigDecimal cost){
            super(id, name, cost);
        }
    }

    @Override
    public IngredientJpa toJpa(Ingredient ingredient) {
        return new IngredientJpa(
            ingredient.getId(),
            ingredient.getName(),
            ingredient.getCost()
        );
    }

    @Override
    public Ingredient toDomain(IngredientJpa jpa) {
        /*var ingredient = Ingredient.create(
            jpa.getId(),
            jpa.getName(),
            jpa.getCost()
        );
        ingredient.clearEvents();
        return ingredient;*/
        return new IngredientMap(
            jpa.getId(),
            jpa.getName(),
            jpa.getCost()
        );
    }

}
