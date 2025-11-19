package com.docencia.personas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Clase Persona
 * Representa una persona con nombre, edad, correo electronico
 * y direccion.
 * 
 * @author JesusLugo2002
 */
@Document(collection = "personas")
public class Persona {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("edad")
    private Integer edad;

    @Field("email")
    private String email;

    @Field("direccion")
    private Direccion direccion;

    public Persona() {
    }

    public Persona(String nombre, Integer edad, String email, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}