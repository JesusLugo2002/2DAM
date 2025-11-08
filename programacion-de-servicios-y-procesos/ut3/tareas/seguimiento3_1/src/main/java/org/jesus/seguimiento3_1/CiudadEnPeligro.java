package org.jesus.seguimiento3_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase CiudadEnPeligro
 * Representa una ciudad en constante peligro que esta encontrando la salvacion
 * gracias a Superman y Batman. 
 * 
 * Cada heroe tiene un tiempo aleatorio en un rango determinado para liberar una zona.
 * Si un heroe libera todas sus zonas designadas, se convierte en ganador.
 * @author JesusLugo2002
 */
public class CiudadEnPeligro {
    static volatile Boolean dangerNeutralized = false;
    static Set<String> zonesA = new HashSet<String>(Arrays.asList("Norte", "Centro", "Este"));
    static Set<String> zonesB = new HashSet<String>(Arrays.asList("Oeste", "Sur"));
    static volatile String winner = null;

    public Boolean getDangerNeutralized() {
        return dangerNeutralized;
    }

    public String getWinner() {
        return winner;
    }

    /**
     * Clase Superman
     * Representa a Superman, quien libera a un ritmo aleatorio las zonas A.
     * @author JesusLugo2002
     */
    public static class Superman implements Runnable {

        @Override
        public void run() {
            for (String zone : zonesA) {
                if (dangerNeutralized) break;
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200, 501));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (dangerNeutralized) break;
                System.out.println("Superman salvó " + zone);
            }
            if (!dangerNeutralized) {
                dangerNeutralized = true;
                winner = "Superman";
                System.out.println("Amenaza neutralizada por Superman");
            }
        }
    }

    /**
     * Clase Batman
     * Representa a Batman, quien libera a un ritmo aleatorio las zonas B.
     * @author JesusLugo2002
     */
    public static class Batman implements Runnable {

        @Override
        public void run() {
            for (String zone : zonesB) {
                if (dangerNeutralized) break;
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(300, 601));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (dangerNeutralized) break;
                System.out.println("Batman salvó " + zone);
            }
            if (!dangerNeutralized) {
                dangerNeutralized = true;
                winner = "Superman";
                System.out.println("Amenaza neutralizada por Batman");
            }
        }
        
    }

    public void main(String[] args) throws InterruptedException {
        Thread superman = new Thread(new Superman());
        Thread batman = new Thread(new Batman());

        superman.start();
        batman.start();

        superman.join();
        batman.join();
    }

}
