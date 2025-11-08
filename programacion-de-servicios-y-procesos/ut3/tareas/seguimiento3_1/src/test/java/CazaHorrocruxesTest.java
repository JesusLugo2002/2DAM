import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.CazaHorrocruxes;
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
        Assertions.assertTrue(CazaHorrocruxes.found);
        Assertions.assertTrue(output.contains(CazaHorrocruxes.winner));
        Assertions.assertEquals(2, output.split("Horrocrux").length);;
    }

}
