package org.jesus.seguimiento3_1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase FabricaDroids
 * Gestiona el proceso de fabricacion de droides. Se fabrican {@code limit} droides, introduciendo
 * los ensamblados en un {@code ArrayBlockingQueue} y contando los activados en el {@code activated}.
 * @author JesusLugo2002
 */
public class FabricaDroids {
    public static int limit = 10;
    static ArrayBlockingQueue<String> ensambled = new ArrayBlockingQueue<>(limit);
    public static AtomicInteger activated = new AtomicInteger(0);
    
    public AtomicInteger getActivated() {
        return activated;
    }

    public int getLimit() {
        return limit;
    }

    /**
     * Clase Ensambler
     * Se encarga de ensamblar los droides, preparandolos para su activacion.
     * @author JesusLugo2002
     */
    public static class Ensambler implements Runnable {

        @Override
        public void run() {            
            for (int i = 0; i <= limit; i++) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100, 301));
                    String droid = "Droid-" + i;
                    System.out.println("Ensamblado " + droid);
                    ensambled.put(droid);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    
    }

    /**
     * Clase Activator
     * Se encarga de activar los droides previamente ensamblados.
     * @author JesusLugo2002
     */
    public static class Activator implements Runnable {

        @Override
        public void run() {
            int count = 0;
            while (count <= limit) {
                try {
                    String droid = ensambled.take();
                    System.out.println("Activado " + droid);
                    count++;
                    if (count > limit) {
                        break;
                    }
                    activated.addAndGet(1);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 151));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    public void main(String[] args) throws InterruptedException {
        Thread ensambler = new Thread(new Ensambler());
        Thread activator = new Thread(new Activator());
        
        ensambler.start();
        activator.start();

        ensambler.join();
        activator.join();
    }

}
