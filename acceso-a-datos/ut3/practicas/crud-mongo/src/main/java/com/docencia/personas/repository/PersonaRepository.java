package com.docencia.personas.repository;

import com.docencia.personas.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends MongoRepository<Persona, String> {

    Optional<Persona> findByEmail(String email);

    List<Persona> findByNombreContainingIgnoreCase(String nombre);

    List<Persona> findByEdadBetween(Integer min, Integer max);

    /**
     * @implNote El contenido de @Query es 'donde direccion.ciudad sea igual al primer
     * argumento', en este caso, {@code String ciudad}
     * @author JesusLugo2002
     */
    @Query("{ 'direccion.ciudad': ?0 }")
    List<Persona> findByCiudad(String ciudad);
}