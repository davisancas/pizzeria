package com.example.demo.features.infraestructure.ingredient;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.demo.features.core.infraestructure.IGetJpa;
import com.example.demo.features.core.infraestructure.Lookup;
import com.example.demo.features.domain.ingredients.Ingredient;

@Component
public class IngredientLookup implements Lookup<Ingredient> {
 
    private final IGetJpa<Ingredient, UUID, IngredientJpa> repository;
 
    public IngredientLookup(IGetJpa<Ingredient, UUID, IngredientJpa> repository) {
        this.repository = repository;
    }
 
    @Override
    public Class<Ingredient> type() {
        return Ingredient.class;
    }
 
    @Override
    public Ingredient find(UUID id) {
        return repository.get(id); // ya lanza EntityNotFoundException
    }

}
