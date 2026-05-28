package com.example.demo.features.infraestructure.ingredient;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredientJpaRepository extends JpaRepository<IngredientJpa, UUID>{

}
