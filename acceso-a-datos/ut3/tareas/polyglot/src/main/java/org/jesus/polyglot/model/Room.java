package org.jesus.polyglot.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * Clase Room.
 * Representa una entidad de habitacion con su numero y precio por noche.
 * 
 * @author JesusLugo2002
 */
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "price_per_night", nullable = false)
    private double pricePerNight;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    /**
     * Constructor vacio
     */
    public Room() {
    }

    /**
     * Constructor con asignacion de id para busquedas SQL.
     * 
     * @param id - Identificador unico de la habitacion.
     */
    public Room(int id) {
        this.id = id;
    }

    /**
     * Constructor con asignacion de campos para la creacion en BBDD.
     * 
     * @param number        - Numero de habitacion.
     * @param pricePerNight - Precio por noche.
     * @param hotel         - Hotel al que pertenece.
     */
    public Room(int number, double pricePerNight, Hotel hotel) {
        this.number = number;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
