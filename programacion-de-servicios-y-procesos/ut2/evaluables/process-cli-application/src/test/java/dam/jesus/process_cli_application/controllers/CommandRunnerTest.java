package dam.jesus.process_cli_application.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dam.jesus.process_cli_application.repositories.impl.FileJobRepository;
import dam.jesus.process_cli_application.services.impl.LsofService;
import dam.jesus.process_cli_application.services.impl.PsService;
import dam.jesus.process_cli_application.services.impl.TopService;

class CommandRunnerTest {
    
    static CommandRunner commandRunner;

    @BeforeAll
    static void beforeAll() {
        commandRunner = new CommandRunner();

        commandRunner.setLsofService(new LsofService());
        commandRunner.setPsService(new PsService());
        commandRunner.setTopService(new TopService());
    }

    @Test
    void testRunLsof() {
        commandRunner.lsofService.setFileJobRepository(new FileJobRepository());
        commandRunner.handle("lsof -i");
        Assertions.assertNotNull(commandRunner.lsofService.getJob());
    }

    @Test
    void testRunPs() {
        commandRunner.psService.setFileJobRepository(new FileJobRepository());
        commandRunner.handle("ps aux | head");
        Assertions.assertNotNull(commandRunner.psService.getJob());
    }

    @Test
    void testRunTop() {
        commandRunner.topService.setFileJobRepository(new FileJobRepository());
        commandRunner.handle("top -n1 -b");
        Assertions.assertNotNull(commandRunner.topService.getJob());
    }

    @Test
    void testRunBlankLine() {
        Assertions.assertFalse(commandRunner.handle(""));
    }
}
