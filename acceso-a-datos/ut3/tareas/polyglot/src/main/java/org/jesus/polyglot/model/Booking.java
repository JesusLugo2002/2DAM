package org.jesus.polyglot.model;

import jakarta.persistence.*;

/**
 * Clase Booking.
 * Representa una entidad de una reserva con sus fechas de check in y check out,
 * la habitacion asignada y el huesped de la reserva.
 * 
 * @author JesusLugo2002
 */
@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "check_in", nullable = false)
    private String checkIn;

    @Column(name = "check_out", nullable = false)
    private String checkOut;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToOne(mappedBy = "booking")
    private Guest guest;

    /**
     * Constructor vacio.
     */
    public Booking() {
    }

    /**
     * Constructor con asignacion de id para busquedas SQL.
     * 
     * @param id - Identificador unico de la reserva.
     */
    public Booking(int id) {
        this.id = id;
    }

    /**
     * Constructor con asignacion de campos para creacion en BBDD.
     * 
     * @param checkIn  - Fecha del Check In.
     * @param checkOut - Fecha del Check Out.
     * @param room     - Habitacion asignada.
     * @param guest    - Huesped que reserva.
     */
    public Booking(String checkIn, String checkOut, Room room, Guest guest) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.guest = guest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

}
