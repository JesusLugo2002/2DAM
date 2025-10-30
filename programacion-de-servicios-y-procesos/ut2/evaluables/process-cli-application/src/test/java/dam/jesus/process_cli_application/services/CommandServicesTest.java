package dam.jesus.process_cli_application.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dam.jesus.process_cli_application.domain.Job;
import dam.jesus.process_cli_application.repositories.FileJobRepository;

class CommandServicesTest {

    static LsofService lsofService;

    static FileJobRepository fileJobRepository;

    @BeforeAll
    static void beforeAll() {
        lsofService = new LsofService();
        fileJobRepository = new FileJobRepository();
        lsofService.setFileJobRepository(fileJobRepository);
    }

    @Test
    void testGoodConstruction() {
        boolean wasBuilt = lsofService.setupCommand("lsof -i");
        Assertions.assertTrue(wasBuilt);
    }

    @Test
    void testConstructionWithoutParameters() {
        boolean wasBuilt = lsofService.setupCommand("lsof");
        Assertions.assertFalse(wasBuilt);
    }

    @Test
    void testConstructionWithMoreLetters() {
        boolean wasBuilt = lsofService.setupCommand("lsofa -i");
        Assertions.assertFalse(wasBuilt);
    }

    @Test
    void testConstructionWithBlankSpaces() {
        boolean wasBuilt = lsofService.setupCommand("      lsof      -i     ");
        Assertions.assertTrue(wasBuilt);
    }

    @Test
    void testGoodCommandRun() {
        boolean wasBuilt = lsofService.setupCommand("lsof -i");
        Assertions.assertTrue(wasBuilt);
        Job serviceJob = lsofService.getJob();
        Assertions.assertNotNull(serviceJob, "The job object was not created!");
        boolean processExecuted = lsofService.runCommand();
        Assertions.assertTrue(processExecuted);
    }
}
