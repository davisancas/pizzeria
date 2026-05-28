package com.example.demo.features.core.infraestructure;

public interface IRemove<T, ID> extends IGet<T, ID> {
    void remove(ID id);
}
