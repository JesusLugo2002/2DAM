package com.docencia.com.examen.hilos;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase CarRace
 * Simula la carrera de dos coches que van tomando distancias
 * de forma aleatoria hasta alcanzar una meta.
 * 
 * @author JesusLugo2002
 */
public class CarRace implements Runnable {
    private String name;
    private int distance = 0;
    private int goal;
    private static volatile Boolean winnerDeclared = false;
    private static volatile String turn = "McQueen";

    /**
     * Constructor con nombre y meta.
     * @param name - nombre del coche.
     * @param goal - meta a alcanzar.
     */
    public CarRace(String name, int goal) {
        this.name = name;
        this.goal = goal;
    }

    /**
     * Procedimiento principal del hilo. 
     * Mientras no se haya determinado un ganador, se calcula la 
     * distancia recorrida de forma aleatoria, se muestra dicha distancia
     * recorrida y, si se ha alcanzado la meta, se determina que existe un
     * ganador y se imprime en pantalla. Si no, se le pasa el turno de avance
     * al otro coche.
     */
    @Override
    public void run() {
        int MIN_STEP = 30;
        int MAX_STEP = 70;

        while (!winnerDeclared) {
            if (!name.equals(turn)) continue;
            distance += ThreadLocalRandom.current().nextInt(MIN_STEP, MAX_STEP);
            System.out.println(name + " lleva " + distance + "/" + goal + " metros.");
            if (distance >= goal) {
                winnerDeclared = true;
                System.out.println(name + " ha ganado la carrera!");
                break;
            }
            turn = name.equals("McQueen") ? "Mate" : "McQueen";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread car1 = new Thread(new CarRace("Mate", 1000));
        Thread car2 = new Thread(new CarRace("McQueen", 1000));

        car1.start();
        car2.start();

        car1.join();
        car2.join();
    }
}