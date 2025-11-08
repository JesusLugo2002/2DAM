import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.ExploradoresJedi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExploradoresJediTest {

    @Test
    public void testExploradoresJedi() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ExploradoresJedi explorers = new ExploradoresJedi();
        explorers.main(null);
        String output = outContent.toString();

        Assertions.assertTrue(explorers.getHintFound());
        Assertions.assertEquals(2, output.split("pista").length);
    }

}
