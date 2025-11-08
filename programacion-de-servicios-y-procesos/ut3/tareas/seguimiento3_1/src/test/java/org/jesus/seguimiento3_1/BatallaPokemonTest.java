package org.jesus.seguimiento3_1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.classes.BatallaPokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BatallaPokemonTest {
    @Test
    public void testBatallaPokemon() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Thread pikachu = new Thread(new BatallaPokemon.ThreadPikachu());
        Thread charmander = new Thread(new BatallaPokemon.ThreadCharmander());

        pikachu.start();
        charmander.start();

        pikachu.join();
        charmander.join();

        String output = outContent.toString();
        Assertions.assertTrue(output.contains("Pikachu ha ganado la batalla") || output.contains("Charmander ha ganado la batalla"));
    }    
}
