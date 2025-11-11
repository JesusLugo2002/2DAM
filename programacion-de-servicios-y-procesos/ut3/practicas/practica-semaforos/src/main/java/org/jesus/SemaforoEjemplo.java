package org.jesus;

import java.util.concurrent.Semaphore;

public class SemaforoEjemplo {
    // Creamos un semáforo con 3 permisos (máximo 3 hilos pueden acceder simultáneamente)
    private static final Semaphore semaforo = new Semaphore(3);

    public static void main(String[] args) {
        // Creamos varios hilos para simular el acceso concurrente a un recurso
        for (int i = 1; i <= 5; i++) {
            new Trabajador("Trabajador " + i).start();
        }
    }

    static class Trabajador extends Thread {
        private String nombre;

        public Trabajador(String nombre) {
            this.nombre = nombre;
        }

        public void run() {
            try {
                System.out.println(nombre + " esperando para acceder al recurso...");
                
                // Adquirimos un permiso del semáforo
                semaforo.acquire();
                System.out.println(nombre + " ha obtenido acceso al recurso.");
                
                // Simulamos trabajo con el recurso
                Thread.sleep(2000);

                // Liberamos el permiso después de usar el recurso
                System.out.println(nombre + " ha terminado y libera el recurso.");
                semaforo.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}