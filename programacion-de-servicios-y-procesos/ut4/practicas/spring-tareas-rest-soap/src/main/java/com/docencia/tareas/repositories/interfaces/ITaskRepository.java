package com.docencia.tareas.repositories.interfaces;

import java.util.List;

import com.docencia.tareas.model.Task;

public interface ITaskRepository {

    /**
     * Add a task.
     * @param task - Task to add.
     * @return Added task.
     */
    public Task add(Task task);

    /**
     * Delete a task.
     * @param task - Task to delete.
     * @return True if deleted, false otherwise.
     */
    public boolean delete(Task task);

    /**
     * Find a task.
     * @param task - Task to find.
     * @return Found task.
     */
    public Task findBy(Task task);

    /**
     * Update an existent task.
     * @param task - Task to update.
     * @return Updated task.
     */
    public Task update(Task task);

    /**
     * Obtain all tasks.
     * @return A list with all the tasks.
     */
    public List<Task> findAll();

}
