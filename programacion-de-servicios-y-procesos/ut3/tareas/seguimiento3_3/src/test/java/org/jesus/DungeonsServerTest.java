package org.jesus;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jesus.DungeonsServer.DungeonRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DungeonsServerTest {

    ByteArrayOutputStream catchOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    @Test
    void testDungeonsServerFinishCorrectly() {
        ByteArrayOutputStream outContent = catchOutput();
        DungeonsServer.main(null);
        String output = outContent.toString();
        Assertions.assertTrue(output.contains("all requests sent"));
    }

    @Test
    void testDungeonRequestWorksCorrectly() throws InterruptedException {
        ByteArrayOutputStream outContent = catchOutput();
        String requestPlayer = "Zekken";
        String requestDungeon = "Darkest Dungeon";
        DungeonRequest request = new DungeonRequest(requestPlayer, requestDungeon);

        Assertions.assertEquals(requestPlayer, request.getPlayer());
        Assertions.assertEquals(requestDungeon, request.getDungeon());

        Thread thread = new Thread(request);
        thread.start();
        thread.join();

        String output = outContent.toString();
        Assertions.assertTrue(output.contains("Loading dungeon") && output.contains(requestDungeon));
        Assertions.assertTrue(output.contains("completed by") && output.contains(requestPlayer));
    }
}
