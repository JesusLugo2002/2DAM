package org.jesus.utils;

import java.time.LocalTime;

/**
 * Clase ThreadLogger.
 * Implementa un logger personalizado que hace uso del nombre del thread
 * y agrega un timestamp si este es necesario.
 * 
 * @author JesusLugo2002
 */
public class ThreadLogger {
    private String thread;

    /**
     * Constructor con asignacion del nombre del thread.
     * @param thread - Hilo en ejecucion del que se extraera su nombre.
     */
    public ThreadLogger(Thread thread) {
        this.thread = "[" + thread.getName() + "]";
    }

    /**
     * Imprime en pantalla un mensaje junto a la etiqueta identificativa del hilo.
     * @param message - Mensaje a imprimir.
     */
    public void out(String message) {
        System.out.println(thread + " " + message);
    }   

    /**
     * Imprime en pantalla un mensaje junto a la etiqueta identificativa del hilo,
     * ademas de una etiqueta timestamp si esta es solicitada.
     * @param message - Mensaje a mostrar.
     * @param addTimestamp - {@code true} si desea agregar el timestamp, {@code false} si no.
     */
    public void out(String message, Boolean addTimestamp) {
        if (!addTimestamp) {
            out(message);
            return;
        }
        String timestamp = "[" + LocalTime.now() + "]";
        System.out.println(timestamp + thread + " " + message);
    }

}
