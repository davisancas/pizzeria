package com.example.demo.features.domain.ingredients;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import com.example.demo.features.core.AgregateBase;

public class Ingredient extends AgregateBase{

    private String name;
    private BigDecimal cost;

    public Ingredient(UUID id, String name, BigDecimal cost) {
        super(id);
        this.name = Objects.requireNonNull(name, "name");
        this.cost = Objects.requireNonNull(cost, "cost");
    }

    //Para creación desde el servicio de coordinación
    public static Ingredient create(UUID id, String name, BigDecimal cost){
        return new Ingredient(id, name, cost);  
    }
    
    public void update(String name, BigDecimal cost) {
        this.name = Objects.requireNonNull(name, "name");
        this.cost = Objects.requireNonNull(cost, "cost");
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    //Para recuperación de JPA
    public static Ingredient hydrate(UUID id, String name, BigDecimal cost){
        return new Ingredient(id, name, cost);
        //Para recuperación de JPA
    }

}

