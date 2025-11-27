package com.docencia.personas.services.implementations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.docencia.personas.model.Rol;
import com.docencia.personas.services.IRolService;

@SpringBootTest
public class RolServiceTest {

    private static final String ROL_NAME = "Rol name";
    private static final String ROL_1 = "ROL-1";
    IRolService rolService;
    Rol rol;

    @Autowired
    public void setRolService(IRolService rolService) {
        this.rolService = rolService;
    }

    @BeforeEach
    void setup() {
        if (rol == null) {
            rol = new Rol(ROL_1, ROL_NAME);
        }
        rolService.save(rol);
    }

    @Test
    void testFind() {
        Rol rolFound = new Rol(ROL_1);
        rolFound = rolService.find(rolFound);
        Assertions.assertNotNull(rolFound);
        Assertions.assertEquals(ROL_1, rolFound.getId());
        Assertions.assertEquals(ROL_NAME, rolFound.getName());
    }

    @AfterEach
    void afterEach() {
        Rol rolFound = new Rol(ROL_1);
        rolService.delete(rolFound);
        rolFound = rolService.find(rolFound);
        Assertions.assertNull(rolFound);
    }
}
