package org.formacion.procesosservicios.services;

import org.formacion.procesos.services.ProcessExecutorLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessExecutorLSTTest {

    ProcessExecutorLS processExecutorLS;
    
    @BeforeEach
    void beforeEach() {
        processExecutorLS = new ProcessExecutorLS();
        processExecutorLS.setupCommand("ls -la");
    }

    @Test
    void validateGoodParameters() {
        String[] commandSegments = {"ls", "-la"};
        boolean isValid = processExecutorLS.validate(commandSegments);
        Assertions.assertTrue(isValid, "Invalid parameters");
    }

    @Test
    void validateBadParameters() {
        String[] commandSegments = {"ls", "-lz"};
        boolean isValid = processExecutorLS.validate(commandSegments);
        Assertions.assertFalse(isValid, "The parameters are valid!");
    }

    @Test
    void validateParametersWithoutSign() {
        String[] commandSegments = {"ls", "a"};
        boolean isValid = processExecutorLS.validate(commandSegments);
        Assertions.assertFalse(isValid, "The parameters are valid!");
    }

    @Test
    void validateOnlyMinusSign() {
        String[] commandSegments = {"ls", "-"};
        boolean isValid = processExecutorLS.validate(commandSegments);
        Assertions.assertFalse(isValid, "The parameters are valid!");
    }

    @Test
    void validateBlankSpace() {
        String[] commandSegments = {"ls"};
        boolean isValid = processExecutorLS.validate(commandSegments);
        Assertions.assertTrue(isValid, "The parameters are valid!");
    }
}
