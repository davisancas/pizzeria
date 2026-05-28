package com.example.demo.features.infraestructure.ingredient;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class IngredientJpa {

    @Id
    private UUID id;

    private String name;

    private BigDecimal cost;

    protected IngredientJpa() {}

    public IngredientJpa(UUID id, String name, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getCost() { return cost; }

    public void setName(String name) { this.name = name; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
}