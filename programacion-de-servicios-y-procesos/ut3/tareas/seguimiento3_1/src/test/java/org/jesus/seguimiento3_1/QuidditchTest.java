package org.jesus.seguimiento3_1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.classes.Quidditch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuidditchTest {
    
    @Test
    public void testQuidditch() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Quidditch quidditch = new Quidditch();
        quidditch.main(null);
        String output = outContent.toString();

        Assertions.assertTrue(output.contains("Snitch dorada atrapada"));
        Assertions.assertTrue(output.contains("Marcador final:"));
    }
}
