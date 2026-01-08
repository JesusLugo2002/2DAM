package com.docencia.tareas.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.tareas.model.Task;
import com.docencia.tareas.repositories.interfaces.ITaskRepository;

@Repository
public class TaskRepository implements ITaskRepository {
    
    private final List<Task> tasks;

    public TaskRepository() {
        Task task1 = new Task(1L, "Buy 1000 cats", "I like cats", false);
        Task task2 = new Task(2L, "Sell 1000 cats", "I like money", false);
        this.tasks = new ArrayList<>();
        this.add(task1); 
        this.add(task2);
    }

    @Override
    public Task add(Task task) {
        if (tasks.contains(task)) {
            return task;
        }
        tasks.add(task);
        return task;
    }

    @Override
    public boolean delete(Task task) {
        return tasks.remove(task);
    }

    @Override
    public Task findBy(Task task) {
        if (!tasks.contains(task)) {
            return null;
        }
        int index = tasks.indexOf(task);
        return tasks.get(index);
    }

    @Override
    public Task update(Task task) {
        int index = tasks.indexOf(task);
        if (index > -1) {
            tasks.set(index, task);
        }
        return task;
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }
}
