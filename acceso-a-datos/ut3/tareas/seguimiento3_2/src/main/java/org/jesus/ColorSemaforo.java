package org.jesus;

import java.util.concurrent.Semaphore;

/**
 * Clase ColorSemaforo
 * Simula el cambio de colores de un semaforo real entre rojo, amarillo y verde.
 * @author JesusLugo2002
 */
public class ColorSemaforo implements Runnable {
    
    private static final Semaphore semaphore = new Semaphore(1, true);
    private final Color color;
    private final static int PROGRAM_LIFETIME_IN_MS = 20000;
    
    /**
     * Constructor con asignacion del color
     * @param color color a asignar
     */
    public ColorSemaforo(Color color) {
        this.color = color;
    }
    
    /**
     * Procedimiento principal del hilo. Guarda en un principio el tiempo
     * para despues medirlo y calcular que el tiempo de ejecucion sea de 20 segundos
     * como prevee la actividad.
     * 
     * Una vez adquiere acceso por el semaforo, dependiendo del color se tomara un tiempo
     * de espera y, al finalizarlo, libera su permiso del semaforo para que el siguiente color lo tome.
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < PROGRAM_LIFETIME_IN_MS) {
            try {
                semaphore.acquire();
                System.out.println("Semaforo en " + color.toString() + ".");
                int waitTimeInMs = color.equals(Color.AMBAR) ? 1000 : 3000;
                Thread.sleep(waitTimeInMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread semaforoRojo = new Thread(new ColorSemaforo(Color.ROJO));
        Thread semaforoVerde = new Thread(new ColorSemaforo(Color.VERDE));
        Thread semaforoAmbar = new Thread(new ColorSemaforo(Color.AMBAR));
        
        semaforoRojo.start();
        semaforoVerde.start();
        semaforoAmbar.start();

        semaforoRojo.join();
        semaforoVerde.join();
        semaforoAmbar.join();
    }
}