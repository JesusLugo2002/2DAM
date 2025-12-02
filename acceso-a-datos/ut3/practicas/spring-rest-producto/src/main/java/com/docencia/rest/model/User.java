package com.docencia.rest.model;

import java.util.Objects;

import jakarta.persistence.*;

/**
 * Clase User.
 * Representa una entidad de usuario.
 * 
 * @author JesusLugo2002
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Constructor vacio
     */
    public User() {
    }

    /**
     * Constructor con asignacion de id.
     * 
     * @param id - Identificador unico del usuario
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * Constructor con la asignacion de todos los campos
     * 
     * @param id   - Identificador unico del usuario.
     * @param name - Nombre del usuario.
     */
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return id == other.id;
    }

}
