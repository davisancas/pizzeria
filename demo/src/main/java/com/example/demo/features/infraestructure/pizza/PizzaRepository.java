package com.example.demo.features.infraestructure.pizza;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.features.core.infraestructure.IAddJpa;
import com.example.demo.features.core.infraestructure.IRemoveJpa;
import com.example.demo.features.core.infraestructure.IUpdateJpa;
import com.example.demo.features.core.infraestructure.Mapper;
import com.example.demo.features.domain.pizza.Pizza;

@Repository
public class PizzaRepository implements
        IAddJpa<Pizza, UUID, PizzaJpa>,
        IUpdateJpa<Pizza, UUID, PizzaJpa>,
        IRemoveJpa<Pizza, UUID, PizzaJpa> {

    private final PizzaJpaRepository jpa;
    private final PizzaMapper mapper;

    public PizzaRepository(PizzaJpaRepository jpa, PizzaMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    @Override
    public JpaRepository<PizzaJpa, UUID> jpa() { return jpa; }

    @Override
    public Mapper<Pizza, PizzaJpa> mapper() { return mapper; }

}
