package com.docencia.tareas.soap;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.tareas.model.Task;
import com.docencia.tareas.service.interfaces.ITaskService;
import com.docencia.tareas.soap.interfaces.ITaskSoapEndpoint;

import jakarta.jws.WebService;

@WebService(serviceName = "taskService", portName = "taskPort", targetNamespace = "https://jesuslugo2002.github.io/", endpointInterface = "com.docencia.tareas.soap.interfaces.ITaskSoapEndpoint")
@Service
public class TaskSoapService implements ITaskSoapEndpoint {

    private final ITaskService service;

    public TaskSoapService(ITaskService service) {
        this.service = service;
    }

    @Override
    public List<Task> findAll() {
        return service.findAll();
    }

    @Override
    public Task findById(Long id) {
        return service.findById(id);
    }

    @Override
    public Task create(String title, String description) {
        return service.create(title, description);
    }

    @Override
    public Task update(Long id, String title, String description, Boolean completed) {
        return service.update(id, title, description, completed);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }

}
