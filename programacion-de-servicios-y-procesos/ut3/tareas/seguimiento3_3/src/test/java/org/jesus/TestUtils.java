package org.jesus;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestUtils {

    public static ByteArrayOutputStream catchOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }
}
