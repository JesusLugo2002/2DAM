package org.jesus;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jesus.DamageCalculator.Attack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DamageCalculatorTest {

    @Test
    void testDamageCalculatorFinishCorrectly() {
        ByteArrayOutputStream outContent = TestUtils.catchOutput();
        DamageCalculator.main(null);
        String output = outContent.toString();
        Assertions.assertTrue(output.contains("Daño total de la raid"));
    }
    
    @Test
    void testAttackCalculatorWorksCorrectly() throws InterruptedException, ExecutionException {
        ByteArrayOutputStream outContent = TestUtils.catchOutput();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Attack attack = new Attack("Zekken", 100, 0.25, 1.5);
        pool.submit(new DamageCalculator.CalculateDamageTask(attack)).get();
        String output = outContent.toString();
        Assertions.assertTrue(output.contains("¡CRÍTICO!") || output.contains("golpe normal"));
        pool.shutdown();
    }

    @Test
    void testCriticalAttackPrintCorrectly() throws InterruptedException, ExecutionException {
        ByteArrayOutputStream outContent = TestUtils.catchOutput();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Attack attack = new Attack("Zekken", 100, 1, 1.5);
        pool.submit(new DamageCalculator.CalculateDamageTask(attack)).get();
        String output = outContent.toString();
        Assertions.assertTrue(output.contains("¡CRÍTICO!"));
        pool.shutdown();
    }

}
