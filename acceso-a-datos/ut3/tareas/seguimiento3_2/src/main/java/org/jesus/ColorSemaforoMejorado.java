package org.jesus;

import java.util.concurrent.Semaphore;

/**
 * Clase ColorSemaforo
 * Simula el cambio de colores de un semaforo real entre rojo, amarillo y verde.
 * Esta version viene mejorada para garantizar el orden de rojo -> verde -> amarillo.
 * @author JesusLugo2002
 */
public class ColorSemaforoMejorado implements Runnable {

    private static final Semaphore redTurn = new Semaphore(1);
    private static final Semaphore greenTurn = new Semaphore(0);
    private static final Semaphore yellowTurn = new Semaphore(0);

    private Color color;
    private final static int PROGRAM_LIFETIME_IN_MS = 20000;

    
    /**
     * Constructor por defecto
     */
    public ColorSemaforoMejorado() {}

    /**
     * Constructor con asignacion del color
     * @param color color a asignar
     */
    public ColorSemaforoMejorado(Color color) {
        this.color = color;
    }

    /**
     * Procedimiento principal del hilo. Guarda en un principio el tiempo
     * para despues medirlo y calcular que el tiempo de ejecucion sea de 20 segundos
     * como prevee la actividad.
     * 
     * Esta version de la clase toma en cuenta el color asignado para determinar
     * cual semaforo activara en su turno y a cual liberara en el siguiente.
     * 
     * Una vez adquiere acceso por el semaforo, dependiendo del color se tomara un tiempo
     * de espera y, al finalizarlo, libera su permiso del semaforo para que el siguiente color lo tome.
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        Semaphore mySemaphore = null;
        Semaphore nextSemaphore = null;

        switch (color) {
            case ROJO:
                mySemaphore = redTurn;
                nextSemaphore = greenTurn;
                break;
            case AMBAR:
                mySemaphore = yellowTurn;
                nextSemaphore = redTurn;
                break;
            case VERDE:
                mySemaphore = greenTurn;
                nextSemaphore = yellowTurn;
                break;
        }

        while (System.currentTimeMillis() - startTime < PROGRAM_LIFETIME_IN_MS) {
            try {
                mySemaphore.acquire();
                System.out.println("Semaforo en " + color.toString() + ".");
                int waitTimeInMs = color.equals(Color.AMBAR) ? 1000 : 3000;
                Thread.sleep(waitTimeInMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                nextSemaphore.release();
            }
        }
    }

    public void main(String[] args) throws InterruptedException {
        Thread semaforoRojo = new Thread(new ColorSemaforoMejorado(Color.ROJO));
        Thread semaforoVerde = new Thread(new ColorSemaforoMejorado(Color.VERDE));
        Thread semaforoAmbar = new Thread(new ColorSemaforoMejorado(Color.AMBAR));

        semaforoRojo.start();
        semaforoVerde.start();
        semaforoAmbar.start();

        semaforoRojo.join();
        semaforoVerde.join();
        semaforoAmbar.join();
    }
}
