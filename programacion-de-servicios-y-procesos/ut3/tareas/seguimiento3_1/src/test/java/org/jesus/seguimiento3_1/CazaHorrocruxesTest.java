package org.jesus.seguimiento3_1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.classes.CazaHorrocruxes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CazaHorrocruxesTest {

    @Test
    public void testCazaHorrocruxes() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Thread harry = new Thread(new CazaHorrocruxes.Hunter("Harry", "Bosque prohibido"));
        Thread hermione = new Thread(new CazaHorrocruxes.Hunter("Hermione", "Biblioteca antigua"));
        Thread ron = new Thread(new CazaHorrocruxes.Hunter("Ron", "Mazmorras del castillo"));

        harry.start();
        hermione.start();
        ron.start();

        harry.join();
        hermione.join();
        ron.join();

        String output = outContent.toString();
        Assertions.assertTrue(output.contains("Harry encontró un Horrocrux en Bosque prohibido")
                || output.contains("Hermione encontró un Horrocrux en Biblioteca antigua")
                || output.contains("Ron encontró un Horrocrux en Mazmorras del castillo"));
    }

}
