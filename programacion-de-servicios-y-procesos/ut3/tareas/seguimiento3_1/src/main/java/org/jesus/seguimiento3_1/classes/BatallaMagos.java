package org.jesus.seguimiento3_1.classes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase BatallaMagos
 * Simula la batalla de Gandalf y Saruman, donde con el tiempo se
 * van realizando ataques de daño aleatorio. El primero de los magos
 * cuya energia llegue a 0 es eliminado y se proclama el otro como
 * ganador.
 * @author JesusLugo2002
 */
public class BatallaMagos {
    static AtomicInteger gandalfEnergy = new AtomicInteger(120);
    static AtomicInteger sarumanEnergy = new AtomicInteger(120);
    static volatile boolean combatFinished = false;
    static ReentrantLock mutex = new ReentrantLock();

    public boolean isCombatFinished() {
        return combatFinished;
    }

    public AtomicInteger getGandalfEnergy() {
        return gandalfEnergy;
    }

    public AtomicInteger getSarumanEnergy() {
        return sarumanEnergy;
    }

    /**
     * Realiza un ataque magico bajo el nombre de {@code attacker} y
     * toma la referencia de {@code rivalEnergy} para disminuir su valor
     * dependiendo del daño de ataque obtenido aleatoriamente.
     * @param attacker nombre del atacante
     * @param rivalEnergy referencia de la energia magica del rival.
     */
    static void throwMagic(String attacker, AtomicInteger rivalEnergy) {
        int damage = ThreadLocalRandom.current().nextInt(8, 26);
        rivalEnergy.addAndGet(-damage);
        System.out.println(attacker + " lanza hechizo por " + damage + ". Energía rival: " + rivalEnergy);
        if (rivalEnergy.get() <= 0 && !combatFinished) {
            combatFinished = true;
            System.out.println(attacker + " gana la batalla mágica.");
        }
    }

    /**
     * Clase Gandalf
     * Representa al mago Gandalf en la batalla magica.
     * @author JesusLugo2002
     */
    public static class Gandalf implements Runnable {

        @Override
        public void run() {
            while (!combatFinished) {
                mutex.lock();
                if (!combatFinished) throwMagic("Gandalf", sarumanEnergy);
                mutex.unlock();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200, 601));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }    
        }
        
    }

    /**
     * Clase Saruman
     * Representa al mago Saruman en la batalla magica.
     * @author JesusLugo2002
     */
    public static class Saruman implements Runnable {

        @Override
        public void run() {
            while (!combatFinished) {
                mutex.lock();
                if (!combatFinished) throwMagic("Saruman", gandalfEnergy);
                mutex.unlock();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200, 601));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }    
        }
        
    }

    public void main(String[] args) throws InterruptedException {
        Thread gandalf = new Thread(new Gandalf());
        Thread saruman = new Thread(new Saruman());
        gandalf.start();
        saruman.start();
        gandalf.join();
        saruman.join();
    }
}
