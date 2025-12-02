package com.docencia.restejercicio.controller;

import com.docencia.restejercicio.model.User;
import com.docencia.restejercicio.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Users operations")
public class UserController {

    private UserService service;

    public void setUserService(UserService userService) {
        this.service = userService;
    }

    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping("/")
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @Operation(summary = "Obtener un usuario por su id")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        return service.getById(userId);
    }

    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping("/")
    public User createUser(@Valid @RequestBody User user) {
        return service.create(user);
    }

    @Operation(summary = "Eliminar un usuario")
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUserById(@PathVariable(value = "id") long userId) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("was_deleted", service.delete(userId));
        return response;
    }

    @Operation(summary = "Actualizar un usuario existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"),
    })
    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") long userId,
            @Valid @RequestBody User userDetails) {
        final User updatedUser = service.update(userId, userDetails);
        return updatedUser;
    }

}
