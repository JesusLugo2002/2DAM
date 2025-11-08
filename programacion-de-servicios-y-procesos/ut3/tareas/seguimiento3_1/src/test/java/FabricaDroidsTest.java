import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.FabricaDroids;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FabricaDroidsTest {

    @Test
    public void testFabricaDroids() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FabricaDroids fabric = new FabricaDroids();
        fabric.main(null);
        String output = outContent.toString();

        for (int droidNum = 0; droidNum <= fabric.getLimit(); droidNum++) {
            int indexOfEnsambled = output.indexOf("Ensamblado Droid-" + droidNum);
            int indexOfActivated = output.indexOf("Activado Droid-" + droidNum);
            Assertions.assertTrue(indexOfEnsambled != -1 && indexOfActivated != -1 && indexOfEnsambled < indexOfActivated);
        }
        Assertions.assertEquals(fabric.getLimit(), fabric.getActivated().get());
    }
}
