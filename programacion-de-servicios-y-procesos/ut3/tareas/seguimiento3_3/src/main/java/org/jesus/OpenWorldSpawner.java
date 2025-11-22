package org.jesus;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jesus.utils.ThreadLogger;

/**
 * Clase OpenWorldSpawner.
 * Simula la generacion de enemigos en zonas aleatorias haciendo uso
 * de un ScheduledExecutorService para la programacion de la tarea.
 * 
 * @author JesusLugo2002
 */
public class OpenWorldSpawner {
    /**
     * Clase SpawnTask.
     * Tarea encargada de generar un enemigo aleatoria en una zona aleatoria
     * y mostrar los resultados.
     * 
     * @author JesusLugo2002
     */
    static class SpawnTask implements Runnable {

        private final String[] zones = {
                "Bosque Maldito",
                "Ruinas Antiguas",
                "Pantano Radiactivo",
                "Ciudad Cibernética",
                "Templo Prohibido"
        };

        private final String[] enemies = {
                "Slime Mutante",
                "Esqueleto Guerrero",
                "Mecha-Dragón",
                "Bandido del Desierto",
                "Lich Supremo"
        };

        /**
         * Procedimiento principal de la tarea.
         * Una vez se ejecuta, se genera la informacion del hilo y el momento en que se 
         * esta generando. Obtiene de forma aleatoria, de la coleccion de enemigos y zonas, un par
         * para luego imprimir toda la informacion.
         */
        @Override
        public void run() {
            ThreadLogger logger = new ThreadLogger(Thread.currentThread());
            String zone = zones[(int) (Math.random() * zones.length)];
            String enemy = enemies[(int) (Math.random() * enemies.length)];
            logger.out("Spawn de " + enemy + " en " + zone, true);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Ejecutar la tarea cada 2 segundos, sin retraso inicial
        scheduler.scheduleAtFixedRate(new SpawnTask(), 0, 2, TimeUnit.SECONDS);

        // Dejamos que el mundo “viva” durante 12 segundos
        Thread.sleep(12000);

        // Apagado ordenado
        System.out.println("Deteniendo spawns...");
        scheduler.shutdown();
        if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forzando parada de spawns.");
            scheduler.shutdownNow();
        }
        System.out.println("Servidor de mundo abierto detenido.");
    }
}
