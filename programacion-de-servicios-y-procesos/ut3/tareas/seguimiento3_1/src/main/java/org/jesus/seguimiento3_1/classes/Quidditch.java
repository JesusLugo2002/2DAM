package org.jesus.seguimiento3_1.classes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase Quidditch
 * Simula una partida de Quidditch donde los equipos van puntuando de forma
 * aleatoria hasta que la snitch dorada sea atrapada.
 * @author JesusLugo2002
 */
public class Quidditch {
    static volatile boolean snitchObtained = false;
    static int aTeamScore = 0;
    static int bTeamScore = 0;
    static ReentrantLock lock = new ReentrantLock();

    /**
     * Clase HunterA
     * Cazador designado para anotar puntos al equipo A.
     * @author JesusLugo2002
     */
    public static class HunterA implements Runnable {

        @Override
        public void run() {
            while (!snitchObtained) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200, 501));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                int newScore = ThreadLocalRandom.current().nextInt(0, 10) * 10;
                if (newScore > 50) {
                    if (!snitchObtained) {
                        lock.lock();
                        aTeamScore += newScore;
                        lock.unlock();
                        System.out.println("Equipo A anota " + newScore + ". Total A = " + aTeamScore);
                    }
                }
            }
        }
        
    } 

    /**
     * Clase HunterB
     * Cazador designado para anotar puntos al equipo B.
     * @author JesusLugo2002
     */
    public static class HunterB implements Runnable {

        @Override
        public void run() {
            while (!snitchObtained) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200, 501));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                int newScore = ThreadLocalRandom.current().nextInt(0, 10) * 10;
                if (newScore > 50) {
                    if (!snitchObtained) {
                        lock.lock();
                        bTeamScore += newScore;
                        lock.unlock();
                        System.out.println("Equipo B anota " + newScore + ". Total A = " + bTeamScore);
                    }
                }
            }
        }
        
    } 

    /**
     * Clase SnitchHunter
     * Persona destinada a atrapar la snitch con una probabilidad aleatoria. Una vez
     * sea atrapada, la partida finaliza.
     * @author JesusLugo2002
     */
    public static class SnitchHunter implements Runnable {

        @Override
        public void run() {
            while (!snitchObtained) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(300, 701));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (ThreadLocalRandom.current().nextInt(1, 101) <= 15) {
                    snitchObtained = true;
                    System.out.println("¡Snitch dorada atrapada!");
                }
            }
        }
        
    } 

    public void main(String[] args) throws InterruptedException {
        Thread hunterA = new Thread(new HunterA());
        Thread hunterB = new Thread(new HunterB());
        Thread snitchHunter = new Thread(new SnitchHunter());

        hunterA.start();
        hunterB.start();
        snitchHunter.start();

        hunterA.join();
        hunterB.join();
        snitchHunter.join();

        System.out.println("Marcador final: A=" + aTeamScore + " B=" + bTeamScore);
    }
}
