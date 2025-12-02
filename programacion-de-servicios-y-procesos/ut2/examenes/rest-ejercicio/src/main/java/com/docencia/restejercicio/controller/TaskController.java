package com.docencia.restejercicio.controller;

import com.docencia.restejercicio.model.Task;
import com.docencia.restejercicio.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks", description = "API de la gestión de tareas")
public class TaskController {

    private TaskService service;

    public void setTaskService(TaskService taskService) {
        this.service = taskService;
    }

    @Operation(summary = "Obtener todas las tareas")
    @GetMapping("/")
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    @Operation(summary = "Obtener una tarea por su id")
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable(value = "id") long taskId) {
        return service.getById(taskId);
    }

    @Operation(summary = "Insertar una tarea")
    @PostMapping("/")
    public Task createTask(@Valid @RequestBody Task task) {
        return service.create(task);
    }

    @Operation(summary = "Eliminar una tarea")
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteTaskById(@PathVariable(value = "id") long taskId) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("was_deleted", service.delete(taskId));
        return response;
    }

    @Operation(summary = "Actualizar una tarea existente")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable(value = "id") long taskId, 
            @Valid @RequestBody Task taskDetails) {
        final Task updatedTask = service.update(taskId, taskDetails);
        return updatedTask;
    }

}
