package org.jesus;

import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpenWorldSpawnerTest {

    @Test
    void testSpawnerWorksCorrectly() throws InterruptedException {
        int AVERAGE_SPAWNS_IN_PROCESS = 5;
        ByteArrayOutputStream outContent = TestUtils.catchOutput();
        OpenWorldSpawner.main(null);
        String output = outContent.toString();

        String[] words = output.split("\\s+");
        int spawnWordOccurrences = 0;
        for (String word : words) {
            if (word.equals("Spawn")) {
                spawnWordOccurrences++;
            }
        }
        Assertions.assertTrue(output.contains("pool-1-thread-1"));
        Assertions.assertTrue(spawnWordOccurrences >= AVERAGE_SPAWNS_IN_PROCESS);
        Assertions.assertTrue(output.contains("Servidor de mundo abierto detenido."));
    }

}
