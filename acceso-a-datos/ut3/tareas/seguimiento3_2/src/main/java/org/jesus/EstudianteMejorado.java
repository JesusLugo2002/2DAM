package org.jesus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase Estudiante
 * Simula el comportamiento de estudiantes tomando prestado una cierta
 * cantidad de equipos de laboratorio, controlando su acceso mediante
 * un semaforo.
 * Esta version tiene como adicion que se comenta el numero del equipo
 * al utilizarlo haciendo uso de la funcion Semaphore.availablePermits()
 * @author JesusLugo2002
 */
public class EstudianteMejorado implements Runnable {

    private final String name;
    private static final Semaphore semaphore = new Semaphore(4);
    private static final int MIN_POSSIBLE_TIME_IN_MS = 3000;
    private static final int MAX_POSSIBLE_TIME_IN_MS = 5000;

    /**
     * Constructor con asignacion del nombre.
     * @param name - nombre del estudiante.
     */
    public EstudianteMejorado(String name) {
        this.name = name;
    }

    /**
     * Procedimiento principal del hilo. Una vez un estudiante
     * adquiere uno de los accesos disponibles del semaforo, empezara a
     * trabajar con el equipamiento por un tiempo aleatorio en un rango determinado.
     * Tambien se indica en el mensaje el numero del equipo utilizado.
     * 
     * Una vez terminado dicho tiempo, se libera el acceso del semaforo para que algun
     * estudiante que haya quedado sin permisos pueda usar un equipo.
     */
    @Override
    public void run() {
        try {
            semaphore.acquire();
            int equipmentNumber = semaphore.availablePermits() + 1;
            System.out.println("El estudiante " + name + " ha comenzado a utilizar el equipo " + equipmentNumber);
            Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_POSSIBLE_TIME_IN_MS, MAX_POSSIBLE_TIME_IN_MS + 1));
            System.out.println("El estudiante " + name + " ha finalizado con el equipo.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
    
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jesus", "Rashi", "German", "Joseph", "Cesar", "David");
        HashSet<Thread> students = new HashSet<Thread>();
        names.forEach((name) -> students.add(new Thread(new EstudianteMejorado(name))));
        students.forEach((student) -> student.start());
        students.forEach((student) -> {
            try {
                student.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
