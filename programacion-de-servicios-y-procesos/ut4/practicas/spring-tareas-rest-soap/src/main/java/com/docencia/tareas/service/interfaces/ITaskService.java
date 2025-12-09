package com.docencia.tareas.service.interfaces;

import com.docencia.tareas.model.Task;
import java.util.List;

public interface ITaskService {

    /**
     * Obtain all the tasks.
     * 
     * @return A list with the tasks.
     */
    public List<Task> findAll();

    /**
     * Obtain a task by the identifier.
     * 
     * @param id - Unique identifier
     * @return The obtained task.
     */
    public Task findById(Long id);

    /**
     * Create a new task.
     * 
     * @param title       - Task title.
     * @param description - Task description.
     * @return Created task.
     */
    public Task create(String title, String description);

    /**
     * Update an existent task.
     * 
     * @param id          - Unique task identifier.
     * @param title       - Task title.
     * @param description - Task description.
     * @param completed   - Task status.
     * @return Updated task.
     */
    public Task update(Long id, String title, String description, Boolean completed);

    /**
     * Delete an existent task.
     * 
     * @param id - Unique task identifier.
     * @return True if was deleted, false otherwise.
     */
    public boolean delete(Long id);

}
