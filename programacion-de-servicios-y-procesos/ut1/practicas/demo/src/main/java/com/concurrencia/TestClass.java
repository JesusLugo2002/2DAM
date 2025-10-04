package com.concurrencia;

import java.util.concurrent.ThreadLocalRandom;

public class TestClass {
    int x;

    public void testMethod1() {
        for (int i = 1; i <= 5; i++) {
            x++;
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1, 6));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void testMethod2() {
        for (int j = 1; j <= 5; j++) {
            x++;
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1, 6));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void sequential() {
        x = 0;
        testMethod1();
        testMethod2();
        System.out.println("Secuencial -> x = " + x);
    }

    public void parallel() {
        x = 0;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod2();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Paralelo -> x = " + x);
    }

    public static void main(String[] args) {
        TestClass obj = new TestClass();
        obj.sequential();
        obj.parallel();
    }
}
