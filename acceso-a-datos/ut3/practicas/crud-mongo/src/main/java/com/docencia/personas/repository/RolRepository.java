package com.docencia.personas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.docencia.personas.model.Rol;

public interface RolRepository extends MongoRepository<Rol, String> {
    
}
