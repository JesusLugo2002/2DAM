package org.jesus.seguimiento3_1.classes;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase ExploradoresJedi
 * Simula la competencia de dos exploradores Jedi para encontrar una
 * pista en algun planeta.
 * @author JesusLugo2002
 */
public class ExploradoresJedi {
    static volatile Boolean hintFound = false;
    static volatile String winner = null;
    
    public Boolean getHintFound() {
        return hintFound;
    }

    public String getWinner() {
        return winner;
    }

    /**
     * Clase Jedi
     * Representa un Jedi / buscador de pistas, al cual se le asigna un nombre
     * y el planeta donde realizara la busqueda.
     * @author JesusLugo2002
     */
    public static class Jedi implements Runnable {
        String name;
        String planet;

        public Jedi(String name, String planet) {
            this.name = name;
            this.planet = planet;
        }

        /**
         * Una vez comience la busqueda, se determina un tiempo restante aleatorio para
         * encontrar la pista. Cuando este tiempo termine, se le da la victoria al Jedi.
         */
        @Override
        public void run() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(400, 1501));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (!hintFound) {
                hintFound = true;
                winner = this.name;
                System.out.println(winner + " halló una pista en " + planet + ". Fin de la busqueda.");
            }
        }

    }

    public void main(String[] args) throws InterruptedException {
        Thread kenobi = new Thread(new Jedi("Kenobi", "Tatooine"));
        Thread skywalker = new Thread(new Jedi("Skywalker", "Dagobah"));

        kenobi.start();
        skywalker.start();

        kenobi.join();
        skywalker.join();
    }
}
