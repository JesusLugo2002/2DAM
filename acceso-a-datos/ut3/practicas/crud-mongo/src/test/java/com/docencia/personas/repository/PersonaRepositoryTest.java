package com.docencia.personas.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;

@SpringBootTest
@ActiveProfiles
public class PersonaRepositoryTest {

    private PersonaRepository repository;
    private Persona personaCollection;
    Direccion direccion;
    Persona personaSaved;

    private String name = "Testicio Testeador";
    private String email = "example@email.com";
    private int age = 18;

    private String directionStreet = "Calle 123";
    private String directionCity = "Los Realejos";
    private String directionCP = "38200";
    private String directionCountry = "Venezuela";
    

    @Autowired
    public void setRepository(PersonaRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    void cleanDatabase() {
        repository.deleteAll();
        personaCollection = new Persona(name, age, email, direccion);
        direccion = new Direccion(directionStreet, directionCity, directionCP, directionCountry);
        personaSaved = repository.save(personaCollection);
    }

    @Test
    void testFind() {
        Assertions.assertEquals(1, repository.count());
        Assertions.assertNotNull(personaSaved);
        Assertions.assertNotNull(personaSaved.getId());
    }

    @Test
    void testFindByCiudad() {
        List<Persona> foundByCiudad = repository.findByCiudad(directionCity);
        Assertions.assertTrue(foundByCiudad.size() >= 1);
        Assertions.assertEquals(directionCity, foundByCiudad.get(0).getDireccion().getCiudad());
    }

    @Test
    void testFindByEdadBetween() {
        int maxAge = 24;
        int minAge = 16;
        Assertions.assertTrue(minAge <= age && maxAge >= age);
        List<Persona> foundByAge = repository.findByEdadBetween(minAge, maxAge);
        Assertions.assertTrue(foundByAge.size() >= 1);
        Assertions.assertEquals(age, foundByAge.get(0).getEdad());
    }

    @Test
    void testFindByEmail() {
        Optional<Persona> foundByEmail = repository.findByEmail(email);
        Assertions.assertEquals(email, foundByEmail.get().getEmail());
    }

    @Test
    void testFindByNombreContainingIgnoreCase() {
        
    }

}
