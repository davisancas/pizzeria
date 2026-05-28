package com.example.demo.features.core.infraestructure;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import static java.util.stream.Collectors.toSet;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import org.springframework.stereotype.Service;

@Service
public class LookupResolver {
    private final Map<Class<?>, Lookup<?>> lookups;

    public LookupResolver(List<Lookup<?>> lookups) {
        this.lookups = lookups.stream()
            .collect(toMap(Lookup::type, identity()));
    }

    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> type, UUID id) {
        Lookup<T> lookup = (Lookup<T>) lookups.get(type);
        if (lookup == null) {
            throw new NoLookupRegisteredException(type);
        }
        return lookup.find(id);
    }

    public <T> Set<T> findAll(Class<T> type, Collection<UUID> ids) {
        return ids.stream()
            .map(id -> find(type, id))
            .collect(toSet());
    }
}
