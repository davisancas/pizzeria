package com.example.demo.features.core.infraestructure;

public interface Mapper<T, J> {
    J toJpa(T domain);
    T toDomain(J jpa);
}
