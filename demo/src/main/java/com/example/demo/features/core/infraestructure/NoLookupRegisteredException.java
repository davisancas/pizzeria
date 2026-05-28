package com.example.demo.features.core.infraestructure;

public class NoLookupRegisteredException extends RuntimeException {
    public NoLookupRegisteredException(Class<?> type) {
        super("No Lookup registered for type: " + type.getName());
    }
}
