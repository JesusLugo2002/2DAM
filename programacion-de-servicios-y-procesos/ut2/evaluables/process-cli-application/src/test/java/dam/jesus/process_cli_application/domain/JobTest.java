package dam.jesus.process_cli_application.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JobTest {

    static Job job;

    @BeforeAll
    static void beforeAll() {
        job = new Job("ps aux | head");
    }

    @Test
    void testJobExecuteProcess() {
        Process process = job.execute();
        Assertions.assertInstanceOf(Process.class, process);
    }

    @Test
    void testJobExecuteWithoutCommand() {
        job.setCommand(null);
        Process process = job.execute();
        Assertions.assertNull(process);
    }

}
