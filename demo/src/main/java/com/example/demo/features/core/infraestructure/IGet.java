package com.example.demo.features.core.infraestructure;

public interface IGet<T, ID> {
    T get(ID id);
}
