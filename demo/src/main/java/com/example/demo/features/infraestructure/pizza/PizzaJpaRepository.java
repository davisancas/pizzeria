package com.example.demo.features.infraestructure.pizza;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaJpaRepository extends JpaRepository<PizzaJpa, UUID>{

}
