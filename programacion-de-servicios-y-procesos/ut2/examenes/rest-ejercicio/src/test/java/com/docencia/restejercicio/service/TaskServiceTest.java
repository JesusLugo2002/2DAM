package com.docencia.restejercicio.service;

import com.docencia.restejercicio.model.Task;
import com.docencia.restejercicio.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskRepository repository;
    private TaskService service;

    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
        repository.save(new Task(null, "Tarea 1", "Descripción 1", false));
        repository.save(new Task(null, "Tarea 2", "Descripción 2", true));

        service = new TaskService(repository);
    }

    @Test
    void getAllTest() {
        List<Task> tasks = service.getAll();
        assertEquals(2, tasks.size(), "Debe haber exactamente 2 tareas iniciales");
    }

    @Test
    void getByIdExistingTaskTest() {
        Task first = service.getAll().get(0);
        Task fromService = service.getById(first.getId());

        assertEquals(first.getId(), fromService.getId());
        assertEquals(first.getTitle(), fromService.getTitle());
    }

    @Test
    void createNewTask() {
        Task created = service.create(new Task(null, "Nueva", "Nueva desc", false));

        assertNotNull(created.getId());
        List<Task> tasks = service.getAll();
        assertEquals(3, tasks.size(), "Tras crear debe haber 3 tareas");
    }

    @Test
    void updateExistingTaskTest() {
        Task first = service.getAll().get(0);
        Long id = first.getId();

        Task update = new Task(null, "Título actualizado", "Desc actualizada", true);
        Task updated = service.update(id, update);

        assertEquals(id, updated.getId());
        assertEquals("Título actualizado", updated.getTitle());
        assertTrue(updated.isDone());
    }

    @Test
    void deleteTaskTest() {
        Task first = service.getAll().get(0);
        Long id = first.getId();

        service.delete(id);

        assertEquals(1, service.getAll().size(), "Tras borrar debe quedar 1 tarea");
        assertThrows(RuntimeException.class, () -> service.getById(id));
    }
}
