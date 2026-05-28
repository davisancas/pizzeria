package com.example.demo.features.core.infraestructure;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.features.core.EntityBase;

public interface RepositoryJpa <T extends EntityBase, ID, J> {
    JpaRepository<J, ID> jpa();
    Mapper<T, J> mapper();

}
