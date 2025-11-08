package org.jesus.seguimiento3_1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.seguimiento3_1.classes.Tardis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TardisTest {
    
    @Test
    public void testTardis() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Tardis tardis = new Tardis();
        tardis.main(null);
        String output = outContent.toString();

        Assertions.assertTrue(tardis.getTargetReached());
        Assertions.assertNotNull(tardis.getWinnerAge());
        Assertions.assertEquals(2, output.split("TARDIS").length);
    }
}
