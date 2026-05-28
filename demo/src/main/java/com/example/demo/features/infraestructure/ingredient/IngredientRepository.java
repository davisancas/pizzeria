package com.example.demo.features.infraestructure.ingredient;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.features.core.infraestructure.IAddJpa;
import com.example.demo.features.core.infraestructure.IRemoveJpa;
import com.example.demo.features.core.infraestructure.IUpdateJpa;
import com.example.demo.features.core.infraestructure.Mapper;
import com.example.demo.features.domain.ingredients.Ingredient;

@Repository
public class IngredientRepository implements 
        IAddJpa<Ingredient, UUID, IngredientJpa>,
        IUpdateJpa<Ingredient, UUID, IngredientJpa>,
        IRemoveJpa<Ingredient, UUID, IngredientJpa> {

    private final IngredientJpaRepository jpa;
    private final IngredientMapper mapper;

    public IngredientRepository(IngredientJpaRepository jpa, IngredientMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    @Override
    public JpaRepository<IngredientJpa, UUID> jpa() { return jpa; }

    @Override
    public Mapper<Ingredient, IngredientJpa> mapper() { return mapper; }

}

