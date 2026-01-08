package com.docencia.tareas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.docencia.tareas.model.Task;
import com.docencia.tareas.repositories.interfaces.ITaskRepository;
import com.docencia.tareas.service.interfaces.ITaskService;

@Service
public class TaskService implements ITaskService {

    ITaskRepository repository;

    public TaskService(ITaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public Task findById(Long id) {
        if (id == null) {
            return null;
        }
        Task task = new Task(id);
        return repository.findBy(task);
    }

    @Override
    public Task create(String title, String description) {
        Long id = UUID.randomUUID().getLeastSignificantBits();
        Task task = new Task(id, title, description, false);
        return repository.add(task);
    }

    @Override
    public Task update(Long id, String title, String description, Boolean completed) {
        if (id == null) {
            return null;
        }
        Task task = new Task(id, title, description, completed);
        return repository.update(task);
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            return false;
        }
        Task task = new Task(id);
        return repository.delete(task);
    }

}
