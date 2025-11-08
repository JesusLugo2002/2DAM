package org.jesus.seguimiento3_1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.classes.CiudadEnPeligro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CiudadEnPeligroTest {
    
    @Test
    public void testCiudadEnPeligro() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CiudadEnPeligro city = new CiudadEnPeligro();
        city.main(null);
        String output = outContent.toString();

        Assertions.assertTrue(city.getDangerNeutralized());
        Assertions.assertTrue(city.getWinner() == "Superman" || city.getWinner() == "Batman");
        Assertions.assertEquals(2, output.split("neutralizada").length);
    }
}
