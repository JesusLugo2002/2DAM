package org.jesus.seguimiento3_1.classes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase BatallaPokemon
 * Esta clase gestiona la batalla de dos pokemons: Pikachu y Charmander, en un combate
 * por turnos con daño aleatorio.
 * @author JesusLugo2002
 */
public class BatallaPokemon {
    static volatile Boolean gameFinished = false;
    static AtomicInteger pikachuHp = new AtomicInteger(100);
    static AtomicInteger charmanderHp = new AtomicInteger(100);
    static String turn = "Pikachu";
    static ReentrantLock mutex = new ReentrantLock();
    static Condition turnChanged = mutex.newCondition();

    private static final int MIN_POSSIBLE_DAMAGE = 5;
    private static final int MAX_POSSIBLE_DAMAGE = 20;

    /**
     * Realiza un ataque bajo el nombre de {@code attackerName}, generando una cantidad de daño
     * aleatoria y modificando la referencia de la vida del rival {@code rivalHp}. Si el ataque
     * ha reducido la vida a 0 o menos en medio de la partida, cambia el estado del juego a
     * completado e imprime el resultado.
     * @param attackerName nombre del atacante.
     * @param rivalHp referencia a la vida del rival.
     */
    public static void attack(String attackerName, AtomicInteger rivalHp) {
        int damage = ThreadLocalRandom.current().nextInt(MIN_POSSIBLE_DAMAGE, MAX_POSSIBLE_DAMAGE + 1);
        rivalHp.addAndGet(-damage);
        System.out.println(attackerName + " ataca con " + damage + " de daño. HP rival: " + rivalHp);
        if (rivalHp.get() <= 0 && !gameFinished) {
            gameFinished = true;
            System.out.println("¡" + attackerName + " ha ganado la batalla!");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Clase ThreadPikachu
     * Ejecuta la acción a realizar por el Thread en nombre de Pikachu.
     * @author JesusLugo2002
     */
    public static class ThreadPikachu implements Runnable {
        @Override
        public void run() {
            while (!gameFinished) {
                mutex.lock();
                while (turn != "Pikachu" && !gameFinished) {
                    try {
                        turnChanged.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (gameFinished) {
                    mutex.unlock();
                    break;
                }
                attack(turn, charmanderHp);
                turn = "Charmander";
                turnChanged.signal();
                mutex.unlock();
            }  
        }
    }

    /**
     * Clase ThreadCharmander
     * Ejecuta la acción a realizar por el Thread en nombre de Charmander
     * @author JesusLugo2002
     */
    public static class ThreadCharmander implements Runnable {
        @Override
        public void run() {
            while (!gameFinished) {
                mutex.lock();
                while (turn != "Charmander" && !gameFinished) {
                    try {
                        turnChanged.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (gameFinished) {
                    mutex.unlock();
                    break;
                }
                attack(turn, charmanderHp);
                turn = "Pikachu";
                turnChanged.signal();
                mutex.unlock();
            }  
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread pikachu = new Thread(new ThreadPikachu());
        Thread charmander = new Thread(new ThreadCharmander());
        pikachu.start();
        charmander.start();
        pikachu.join();
        charmander.join();
    }
}
