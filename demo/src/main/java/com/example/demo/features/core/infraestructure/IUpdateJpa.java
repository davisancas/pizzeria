package com.example.demo.features.core.infraestructure;

import com.example.demo.features.core.EntityBase;

public interface IUpdateJpa<T extends EntityBase, ID, J>
        extends IGetJpa<T, ID, J>, IUpdate<T, ID> {

    @Override
    @SuppressWarnings("unchecked")
    default void update(T entity) {
        get((ID) entity.getId());                  // ← lanza si no existe
        jpa().save(mapper().toJpa(entity));
    }
}
