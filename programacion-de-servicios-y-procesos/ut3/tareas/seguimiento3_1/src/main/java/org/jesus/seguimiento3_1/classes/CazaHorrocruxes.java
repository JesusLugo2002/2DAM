package org.jesus.seguimiento3_1.classes;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase CazaHorrocruxes
 * Clase que gestiona la busqueda o caza de Horrocruxes con la creacion de buscadores.
 * @author JesusLugo2002
 */
public class CazaHorrocruxes {
    public static volatile Boolean found = false;
    public static volatile String winner = null;
    private static final int MIN_RANDOM_TIME_IN_MS = 500;
    private static final int MAX_RANDOM_TIME_IN_MS = 2000;

    /**
     * Clase Hunter
     * Clase del buscador de Horrocruxes al que se le asigna un nombre y un lugar
     * a buscar.
     * @author JesusLugo2002
     */
    public static class Hunter implements Runnable {
        private String name;
        private String location;

        public Hunter(String name, String location) {
            this.name = name;
            this.location = location;
        }

        /**
         * Al iniciar la busqueda, se le asigna un tiempo restante para encontrar el Horrocrux. Una vez
         * llega a 0 el tiempo, el horrocrux es encontrado, imprimiendo en terminal el resultado.
         */
        @Override
        public void run() {
            int timeInMs = ThreadLocalRandom.current().nextInt(MIN_RANDOM_TIME_IN_MS, MAX_RANDOM_TIME_IN_MS + 1);
            try {
                Thread.sleep(timeInMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (!found) {
                found = true;
                winner = this.name;
                System.out.println(this.name + " encontró un Horrocrux en " + location + ". ¡Búsqueda terminada!");
            }
        } 
    }

    public static void main(String[] args) throws InterruptedException {
        Thread harry = new Thread(new Hunter("Harry", "Bosque prohibido"));
        Thread hermione = new Thread(new Hunter("Hermione", "Biblioteca antigua"));
        Thread ron = new Thread(new Hunter("Ron", "Mazmorras del castillo"));
        harry.start();
        hermione.start();
        ron.start();
        harry.join();
        hermione.join();
        ron.join();
    }
}
