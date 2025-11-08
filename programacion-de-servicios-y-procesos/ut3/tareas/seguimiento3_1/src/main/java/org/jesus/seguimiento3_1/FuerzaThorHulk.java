package org.jesus.seguimiento3_1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase FuerzaThorHulk
 * Simula un desafio de fuerza entre Thor y Hulk. Por el tiempo determinado en
 * {@code durationMs}, ambos competidores iran aumentando su puntuacion en
 * {@code totalThor} y {@code totalHulk}. Cuando el tiempo termine, se le 
 * da victoria a aquel competidor con mayor puntaje.
 * @author JesusLugo2002
 */
public class FuerzaThorHulk {
    static int durationMs = 5000;
    static volatile boolean timeFinished = false;
    static AtomicInteger totalThor = new AtomicInteger(0);
    static AtomicInteger totalHulk = new AtomicInteger(0);

    /**
     * Clase Timer
     * Representa el temporizador del desafio. Su tiempo es
     * determinado en la variable de clase {@code durationMs}.
     * @author JesusLugo2002
     */
    public static class Timer implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(durationMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            timeFinished = true;
            System.out.println("¡Tiempo!");    
        }
        
    }

    /**
     * Clase Thor
     * Representa a Thor como competidor del desafio. Mientras
     * el temporizador este activo, ira aumentando su puntuacion
     * a un ritmo aleatorio.
     * @author JesusLugo2002
     */
    public static class Thor implements Runnable {

        @Override
        public void run() {
            while (!timeFinished) {
                int score = ThreadLocalRandom.current().nextInt(5, 21);
                totalThor.addAndGet(score);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 121));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }    
        }
        
    }

    /**
     * Clase Hulk
     * Representa a Hulk como competidor del desafio. Mientras
     * el temporizador este activo, ira aumentando su puntuacion
     * a un ritmo aleatorio.
     * @author JesusLugo2002
     */
    public static class Hulk implements Runnable {

        @Override
        public void run() {
            while (!timeFinished) {
                int score = ThreadLocalRandom.current().nextInt(5, 21);
                totalHulk.addAndGet(score);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 121));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }    
        }
        
    }

    public void main(String[] args) throws InterruptedException {
        Thread timer = new Thread(new Timer());
        Thread thor = new Thread(new Thor());
        Thread hulk = new Thread(new Hulk());

        timer.start();
        thor.start();
        hulk.start();

        timer.join();
        thor.join();
        hulk.join();

        if (totalHulk.get() > totalThor.get()) {
            System.out.println("Hulk gana con " + totalHulk + " vs " + totalThor);
        } else if (totalThor.get() > totalHulk.get()) {
            System.out.println("Thor gana con " + totalThor + " vs " + totalHulk);
        } else {
            System.out.println("Empate: " + totalThor);
        }
    }

}
