package com.example.demo.features.core.infraestructure;

public interface IUpdate<T, ID> extends IGet<T, ID> {
    void update(T entity);
}
