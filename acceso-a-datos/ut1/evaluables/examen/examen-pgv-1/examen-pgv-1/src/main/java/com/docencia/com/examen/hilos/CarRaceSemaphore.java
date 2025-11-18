package com.docencia.com.examen.hilos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase CarRaceSemaphore
 * Simula la carrera de dos carros que van tomando distancias
 * de forma aleatoria hasta alcanzar una meta. Esta vez, la 
 * alternancia es lograda con el uso de un Semaforo.
 * 
 * @author JesusLugo2002
 */
public class CarRaceSemaphore implements Runnable {
    private String name;
    private int goal;
    private int distance = 0;
    private static final Semaphore semaphore = new Semaphore(1, true);
    private static volatile Boolean winnerDeclared = false;
    
    /**
     * Constructor con nombre y meta.
     * @param name - nombre del coche.
     * @param goal - meta a alcanzar.
     */
    public CarRaceSemaphore(String name, int goal) {
        this.name = name;
        this.goal = goal;
    }

    /**
     * Procedimiento principal del hilo. 
     * Mientras no se haya determinado un ganador, se toma el turno por
     * parte del semaforo si este es existente, se calcula la 
     * distancia recorrida de forma aleatoria, se muestra dicha distancia
     * recorrida y, si se ha alcanzado la meta, se determina que existe un
     * ganador y se imprime en pantalla. Si no, se devuelve el turno para el
     * siguiente coche.
     */
    @Override
    public void run() {
        int MIN_STEP = 10;
        int MAX_STEP = 15;

        while (!winnerDeclared) {
            try {
                semaphore.acquire();
                if (winnerDeclared) break;
                distance += ThreadLocalRandom.current().nextInt(MIN_STEP, MAX_STEP);
                System.out.println(name + " lleva " + distance + "/" + goal + " metros.");
                if (distance >= goal) {
                    winnerDeclared = true;
                    System.out.println(name + " ha ganado la carrera!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("    🏁 CARRERA DE COCHES 🏁");
        System.out.println("   Rayo-McQueen vs Mate");

        System.out.println("═══════════════════════════════════════");
        
        int raceGoal = 100;
        
        Thread rayoMcQueen = new Thread(new CarRaceSemaphore("Rayo-McQueen", raceGoal));
        Thread mate = new Thread(new CarRaceSemaphore("Mate", raceGoal));

        rayoMcQueen.start();
        mate.start();

        try {
            rayoMcQueen.join();
            mate.join();
            
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("        🏁 CARRERA TERMINADA 🏁");
            System.out.println("═══════════════════════════════════════");
            
        } catch (InterruptedException e) {
            System.out.println("La carrera fue interrumpida!");
        }
    }
    
    
}
