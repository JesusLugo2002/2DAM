package com.docencia.com.examen.procesos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.com.examen.procesos.controllers.CliController;
import com.docencia.com.examen.procesos.services.impl.DfServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CliControllerTest {

    private CliController cliController;
    private DfServiceImpl dfService;

    @BeforeEach
    void setUp() {
        dfService = new DfServiceImpl();

        cliController = new CliController();
        cliController.dfService = dfService;
    }

    @Test
    void testConsoleMenuDfCommand() {
        String input = "df -h";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        assertDoesNotThrow(() -> cliController.consoleMenu());
    }

    @Test
    void testConsoleMenuTopCommand() {
        String input = "top\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        assertDoesNotThrow(() -> cliController.consoleMenu());
    }

    
    @Test
    public void testConsoleMenu_InvalidCommand() {
        String input = "invalid command\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        assertDoesNotThrow(() -> cliController.consoleMenu());
    }
}
