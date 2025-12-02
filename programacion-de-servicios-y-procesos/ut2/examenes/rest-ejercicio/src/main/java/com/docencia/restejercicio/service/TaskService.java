package com.docencia.restejercicio.service;

import org.springframework.stereotype.Service;

import com.docencia.restejercicio.model.Task;
import com.docencia.restejercicio.repository.TaskRepository;

@Service
public class TaskService extends AbstractService<Task> {

    public TaskService(TaskRepository repository) {
        setRepository(repository);
    }
}
