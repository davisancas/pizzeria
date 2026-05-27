package com.example.demo.features.core;

import java.util.Objects;
import java.util.UUID;

public abstract class EntityBase {

    private final UUID id;

    protected EntityBase(UUID id){
        this.id = Objects.requireNonNull(id, "id");
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityBase that)) return false;
        return id.equals(that.id);
    }

}
