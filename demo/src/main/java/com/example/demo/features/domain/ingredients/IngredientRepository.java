package com.example.demo.features.domain.ingredients;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository {

    Ingredient save(Ingredient ingredient);

    Optional<Ingredient> findById(UUID id);

    List<Ingredient> findAll();

    void deleteById(UUID id);

}

