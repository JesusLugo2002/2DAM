package com.docencia.restejercicio.model;

import com.docencia.restejercicio.repository.interfaces.Identifiable;

/**
 * Clase Task.
 * Representa una tarea.
 */
public class Task implements Identifiable {

    private Long id;
    private String title;
    private String description;
    private boolean done;

    /**
     * Constructor por defecto.
     */
    public Task() {
    }

    /**
     * Constructor con asignacion de valores.
     * 
     * @param id          - Identificador de la tarea.
     * @param title       - Titulo de la tarea.
     * @param description - Descripcion.
     * @param done        - Estado de completado.
     */
    public Task(Long id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
