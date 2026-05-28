package com.example.demo.features.infraestructure.pizza;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.example.demo.features.infraestructure.ingredient.IngredientJpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class PizzaJpa {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "pizza_ingredient",
        joinColumns = @JoinColumn(name = "pizza_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<IngredientJpa> ingredients = new HashSet<>();

    protected PizzaJpa() { }

    public PizzaJpa(UUID id, String name, String description, String url, Set<IngredientJpa> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.ingredients = ingredients;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getUrl() { return url; }
    public Set<IngredientJpa> getIngredients() { return ingredients; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setUrl(String url) { this.url = url; }
    public void setIngredients(Set<IngredientJpa> ingredients) { this.ingredients = ingredients; }
}
