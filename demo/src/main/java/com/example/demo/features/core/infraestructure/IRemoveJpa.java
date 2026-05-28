package com.example.demo.features.core.infraestructure;

import com.example.demo.features.core.EntityBase;

public interface IRemoveJpa<T extends EntityBase, ID, J>
        extends IGetJpa<T, ID, J>, IRemove<T, ID> {

    @Override
    default void remove(ID id) {
        get(id);                                    // ← lanza si no existe
        jpa().deleteById(id);
    }
}
