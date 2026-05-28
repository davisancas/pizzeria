package com.example.demo.features.core.infraestructure;

import java.util.UUID;

public interface Lookup<T> {
    Class<T> type();
    T find(UUID id); // lanza si no existe
}
