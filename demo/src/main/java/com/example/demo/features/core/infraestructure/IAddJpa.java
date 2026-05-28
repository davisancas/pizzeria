package com.example.demo.features.core.infraestructure;

import com.example.demo.features.core.EntityBase;

public interface IAddJpa<T extends EntityBase, ID, J> extends RepositoryJpa<T, ID, J>, IAdd<T> {

    @Override
    default void add(T entity) {
        jpa().save(mapper().toJpa(entity));
    }
}
