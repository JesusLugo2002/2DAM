import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.MilleniumFalcon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MilleniumFalconTest {

    @Test
    public void testMilleniumFalcon() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MilleniumFalcon milleniunBattle = new MilleniumFalcon();
        milleniunBattle.main(null);
        String output = outContent.toString();

        Assertions.assertTrue(output.contains("se destruye") || output.contains("escapan"));
    }
}
