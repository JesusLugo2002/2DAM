package com.docencia.restejercicio.service;

import com.docencia.restejercicio.model.User;
import com.docencia.restejercicio.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserRepository repository;
    private UserService service;

    @BeforeEach
    void setUp() {
        repository = new UserRepository();
        repository.save(new User(null, "juan", "juan@example.com"));
        repository.save(new User(null, "maria", "maria@example.com"));

        service = new UserService(repository);
    }

    @Test
    void getAllUsersTest() {
        List<User> users = service.getAll();
        assertEquals(2, users.size(), "Debe haber exactamente 2 usuarios iniciales");
    }

    @Test
    void getByIdExistingUserTest() {
        User first = service.getAll().get(0);
        User fromService = service.getById(first.getId());

        assertEquals(first.getId(), fromService.getId());
        assertEquals(first.getUsername(), fromService.getUsername());
    }

    @Test
    void createNewUserTest() {
        User created = service.create(new User(null, "ana", "ana@example.com"));

        assertNotNull(created.getId());
        List<User> users = service.getAll();
        assertEquals(3, users.size(), "Tras crear debe haber 3 usuarios");
    }

    @Test
    void updateExistingUserTest() {
        User first = service.getAll().get(0);
        Long id = first.getId();

        User update = new User(null, "juan_actualizado", "nuevo@example.com");
        User updated = service.update(id, update);

        assertEquals(id, updated.getId());
        assertEquals("juan_actualizado", updated.getUsername());
        assertEquals("nuevo@example.com", updated.getEmail());
    }

    @Test
    void deleteUserTest() {
        User first = service.getAll().get(0);
        Long id = first.getId();

        service.delete(id);

        assertEquals(1, service.getAll().size(), "Tras borrar debe quedar 1 usuario");
        assertThrows(RuntimeException.class, () -> service.getById(id));
    }
}
