import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.ColorSemaforo;
import org.jesus.ColorSemaforoMejorado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ColorSemaforoTest {

    ByteArrayOutputStream outContent;

    @BeforeEach
    void beforeEach() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testColorSemaforo() throws InterruptedException {
        ColorSemaforo colorSemaforo = new ColorSemaforo();
        colorSemaforo.main(null);

        String output = outContent.toString();
        Assertions.assertTrue(output.contains("ROJO") && output.contains("VERDE") && output.contains("AMBAR"));
    }

    @Test
    void testColorSemaforoMejorado() throws InterruptedException {
        ColorSemaforoMejorado colorSemaforo = new ColorSemaforoMejorado();
        colorSemaforo.main(null);

        String output = outContent.toString();
        Assertions.assertTrue(output.contains("ROJO") && output.contains("VERDE") && output.contains("AMBAR"));
        Assertions.assertTrue(output.indexOf("ROJO") < output.indexOf("VERDE"));
        Assertions.assertTrue(output.indexOf("VERDE") < output.indexOf("AMBAR"));
    }
}
