package com.example.demo.features.core.infraestructure;


import com.example.demo.features.core.EntityBase;

import jakarta.persistence.EntityNotFoundException;

public interface IGetJpa<T extends EntityBase, ID, J>
        extends RepositoryJpa<T, ID, J>, IGet<T, ID> {

    @Override
    default T get(ID id) {
        return jpa().findById(id)
            .map(mapper()::toDomain)
            .orElseThrow(() -> new EntityNotFoundException());
    }
}
