package dam.jesus.process_cli_application.repositories;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dam.jesus.process_cli_application.domain.Job;
import dam.jesus.process_cli_application.repositories.impl.FileJobRepository;

class FileJobRepositoryTest {

    static FileJobRepository fileJobRepository;
    static Job testJob;
    static Path filepath;
    
    @BeforeAll
    static void beforeAll() {
        fileJobRepository = new FileJobRepository();
        testJob = new Job("lsof -i");
        filepath = Paths.get("logs/" + testJob.getId() + ".txt");
    }

    @Test
    void testCreateFile() {
        fileJobRepository.createFile(filepath);
        Assertions.assertTrue(fileJobRepository.exists(filepath));
    }

    @Test
    void testCreateFileWithoutFilepath() {
        boolean fileCreated = fileJobRepository.createFile(null);
        Assertions.assertFalse(fileCreated);
    }

    @Test
    void testWriteFileWithoutProcessJob() {
        Job jobWithoutExecute = new Job("lsof -i");
        boolean wasWrote = fileJobRepository.writeFile(jobWithoutExecute);
        Assertions.assertFalse(wasWrote);
    }

    @Test
    void testWriteFile() {
        testJob.execute();
        fileJobRepository.writeFile(testJob);
        Assertions.assertTrue(fileJobRepository.exists(filepath));
    }
}
