package org.jesus.seguimiento3_1.classes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase MilleniumFalcon
 * Simula la persecucion de dos naves, con 3 posibles resultados 
 * obtenidos aleatoriamente: la destruccion de escudos de Chewbacca, el fallo
 * del hiperimpulsor de la nave de Han Solo, o con suerte, el escape de ambos
 * de forma exitosa si el tiempo de la mision acaba.
 * @author JesusLugo2002
 */
public class MilleniumFalcon {
    static volatile boolean end = false;
    static volatile boolean destroyed = false;
    static int missionTimeInMs = 4000;
    static long start;

    static AtomicInteger speed = new AtomicInteger(0);
    static AtomicInteger shields = new AtomicInteger(100);

    /**
     * Clase HanSolo
     * Representa la nave de Han Solo, cuya velocidad va incrementando, pero tambien
     * tiene una posibilidad de que su hiperimpulsor falle.
     * @author JesusLugo2002
     */
    public static class HanSolo implements Runnable {

        @Override
        public void run() {
            while(!end) {
                speed.addAndGet(ThreadLocalRandom.current().nextInt(5, 16));
                if (ThreadLocalRandom.current().nextInt(1, 101) <= 5) {
                    destroyed = true;
                    end = true;
                    System.out.println("Fallo del hiperimpulsor. ¡La nave se destruye!");
                }
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (System.currentTimeMillis() - start >= missionTimeInMs) {
                    end = true;  
                }
            }    
        }
        
    }

    /**
     * Clase Chewbacca
     * Representa la nave de Chewbacca, cuyos escudos aumentan y disminuyen de forma
     * aleatoria. Si sus escudos llegan a 0, su nave es destruida.
     * @author JesusLugo2002
     */
    public static class Chewbacca implements Runnable {

        @Override
        public void run() {
            while(!end) {
                shields.addAndGet(ThreadLocalRandom.current().nextInt(-10, 6));
                if (shields.get() <= 0) {
                    destroyed = true;
                    end = true;
                    System.out.println("¡Escudos agotados! ¡La nave se destruye!");
                }
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (System.currentTimeMillis() - start >= missionTimeInMs) end = true;  
            }    
        }
        
    }

    public void main(String[] args) throws InterruptedException {
        start = System.currentTimeMillis();
        System.out.println(start);
        Thread hanSolo = new Thread(new HanSolo());
        Thread chewbacca = new Thread(new Chewbacca());
        hanSolo.start();
        chewbacca.start();
        hanSolo.join();
        chewbacca.join();
        if (!destroyed) {
            System.out.println("¡Han y Chewie escapan! Vel=" + speed + ", Escudos=" + shields);
        }
    }
}
