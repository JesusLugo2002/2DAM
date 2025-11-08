import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.BatallaMagos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BatallaMagosTest {
    
    @Test
    public void testBatallaMagos() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BatallaMagos magesBattle = new BatallaMagos();
        magesBattle.main(null);
        String output = outContent.toString();

        Assertions.assertTrue(output.contains("gana la batalla mágica"));
        Assertions.assertTrue(magesBattle.isCombatFinished());
        Assertions.assertTrue(magesBattle.getGandalfEnergy().get() <= 0 || magesBattle.getSarumanEnergy().get() <= 0);
    }
}
