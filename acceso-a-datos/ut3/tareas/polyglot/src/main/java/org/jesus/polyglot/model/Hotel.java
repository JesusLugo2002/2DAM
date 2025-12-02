package org.jesus.polyglot.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * Clase Hotel.
 * Representa una entidad de hotel con su nombre, direccion y habitaciones.
 * 
 * @author JesusLugo2002
 */
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();

    /**
     * Constructor vacio
     */
    public Hotel() {
    }

    /**
     * Constructor con asignacion de id para busquedas SQL.
     * 
     * @param id - Identificador unico del hotel.
     */
    public Hotel(int id) {
        this.id = id;
    }

    /**
     * Constructor con asignacion de campos para creacion en BBDD
     * 
     * @param name    - Nombre del hotel.
     * @param address - Direccion del hotel.
     */
    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}
