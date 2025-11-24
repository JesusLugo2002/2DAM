package com.docencia.personas.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Clase Rol.
 * Representa el rol de una persona.
 * 
 * @author JesusLugo2002
 */
@Document(collection = "roles")
public class Rol {
    @Id
    private String id;

    @Field("name")
    private String name;

    /**
     * Constructor por defecto
     */
    public Rol() {
    }

    /**
     * Constructor con el identificador del rol.
     * 
     * @param id - Identificador del rol.
     */
    public Rol(String id) {
        this.id = id;
    }

    /**
     * Constructor de la clase con propiedades.
     * 
     * @param id   - Identificador del rol.
     * @param name - Nombre del rol.
     */
    public Rol(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rol other = (Rol) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
