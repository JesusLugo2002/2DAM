package org.jesus.seguimiento3_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase Tardis
 * Simula un viaje aleatorio de la TARDIS y determina como era ganadora el destino
 * al que se ha llegado.
 * @author JesusLugo2002
 */
public class Tardis {
    static volatile Boolean targetReached = false;
    static volatile String winnerAge = null;

    public Boolean getTargetReached() {
        return targetReached;
    }

    public String getWinnerAge() {
        return winnerAge;
    }

    /**
     * Clase Travel
     * Representa un viaje a una era {@code age} determinada. Se asigna un
     * temporizador aleatorio y, en cuanto se acabe, se dictamina como era
     * ganadora el destino del viaje.
     * @author JesusLugo2002
     */
    public static class Travel implements Runnable {
        String age;

        public Travel(String age) {
            this.age = age;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (!targetReached) {
                targetReached = true;
                winnerAge = age;
                System.out.println("La TARDIS llegó primero a " + age);
            }
        }
    }

    public void main(String[] args) {
        Set<String> ages = new HashSet<String>(
                Arrays.asList("Roma Antigua", "Futuro Lejano", "Era Victoriana", "Año 3000"));
        Set<Thread> travels = new HashSet<Thread>();
        ages.forEach(age -> {
            Thread newTravel = new Thread(new Travel(age));
            newTravel.start();
            travels.add(newTravel);
        });
        travels.forEach(travel -> {
            try {
                travel.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

}
