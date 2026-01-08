package com.docencia.tareas.model;

import java.util.Objects;
import jakarta.xml.bind.annotation.*;

/**
 * Class Task.
 * Represents a task.
 * 
 * @author JesusLugo2002
 */
@XmlRootElement(name = "tarea")
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    /**
     * Empty constructor
     */
    public Task() {
    }

    /**
     * Constructor with id for queries.
     * 
     * @param id - Unique identifier
     */
    public Task(Long id) {
        this.id = id;
    }

    /**
     * Constructor with all fields
     * 
     * @param id          - Unique identifier
     * @param title       - Task title
     * @param description - Task description
     * @param completed   - Task status
     */
    public Task(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", completed=" + completed
                + "]";
    }

}
