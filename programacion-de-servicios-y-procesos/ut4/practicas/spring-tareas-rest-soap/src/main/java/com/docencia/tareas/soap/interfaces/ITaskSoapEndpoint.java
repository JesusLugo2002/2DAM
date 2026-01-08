package com.docencia.tareas.soap.interfaces;

import java.util.List;

import com.docencia.tareas.model.Task;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(targetNamespace = "https://jesuslugo2002.github.io/", name = "TaskPortType")
public interface ITaskSoapEndpoint {

    /**
     * Obtain all the tasks.
     * 
     * @return A list with the tasks.
     */
    @WebMethod(operationName = "findAll")
    public List<Task> findAll();

    /**
     * Obtain a task by the identifier.
     * 
     * @param id - Unique identifier
     * @return The obtained task.
     */
    @WebMethod(operationName = "findById")
    public Task findById(@WebParam(name = "identifier") Long id);

    /**
     * Create a new task.
     * 
     * @param title       - Task title.
     * @param description - Task description.
     * @return Created task.
     */
    @WebMethod(operationName = "create")
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
    @WebMethod(operationName = "update")
    public Task update(@WebParam(name = "identifier") Long id, String title, String description, Boolean completed);

    /**
     * Delete an existent task.
     * 
     * @param id - Unique task identifier.
     * @return True if was deleted, false otherwise.
     */
    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "identifier") Long id);

}
