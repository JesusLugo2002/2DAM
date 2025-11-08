import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.FuerzaThorHulk;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuerzaThorHulkTest {
    
    @Test
    public void testFuerzaThorHulk() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FuerzaThorHulk fuerza = new FuerzaThorHulk();
        fuerza.main(null);
        String output = outContent.toString();

        Assertions.assertTrue(output.contains("Tiempo"));
        Assertions.assertTrue(output.contains("gana") || output.contains("Empate"));
    }
}
