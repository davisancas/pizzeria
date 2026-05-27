package com.example.demo.features.infraestructure.ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.demo.features.domain.ingredients.Ingredient;
import com.example.demo.features.domain.ingredients.IngredientRepository;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository{
    
private final Map<UUID, Ingredient> storage = new ConcurrentHashMap<>();

    @Override
    public Ingredient save(Ingredient ingredient) {
        storage.put(ingredient.getId(), ingredient);
        return ingredient;
    }

    @Override
    public Optional<Ingredient> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Ingredient> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(UUID id) {
        storage.remove(id);
    }
}
