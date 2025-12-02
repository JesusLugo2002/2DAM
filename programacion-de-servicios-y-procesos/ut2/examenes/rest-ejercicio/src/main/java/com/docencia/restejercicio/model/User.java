package com.docencia.restejercicio.model;

import com.docencia.restejercicio.repository.interfaces.Identifiable;

/**
 * Clase User.
 * Representa un usuario.
 */
public class User implements Identifiable {

    private Long id;
    private String username;
    private String email;

    /**
     * Constructor por defecto.
     */
    public User() {
    }

    /**
     * Constructor con asignacion de valores
     * 
     * @param id       - Identificador unico del usuario.
     * @param username - Nombre de usuario.
     * @param email    - Correo electronico.
     */
    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
