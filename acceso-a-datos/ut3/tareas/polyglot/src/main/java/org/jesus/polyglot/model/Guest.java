package org.jesus.polyglot.model;

import org.jesus.polyglot.model.nosql.GuestPreferences;

import jakarta.persistence.*;

/**
 * Clase Guest.
 * Representa una entidad de un huesped, con su nombre completo, correo
 * electronico, numero telefonico y preferencias personales.
 * 
 * @author JesusLugo2002s
 */
@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Transient
    private GuestPreferences preferences;

    /**
     * Constructor vacio.
     */
    public Guest() {
    }

    /**
     * Constructor con asignacion de id para busquedas SQL.
     * 
     * @param id - Identificador unico del huesped.
     */
    public Guest(int id) {
        setId(id);
    }

    /**
     * Constructor con asignacion de campos para creacion en BBDD.
     * 
     * @param fullname    - Nombre completo del huesped.
     * @param email       - Correo electronico.
     * @param phoneNumber - Numero de telefono.
     */
    public Guest(String fullname, String email, String phoneNumber) {
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Guest [id=" + getId() + ", fullname=" + fullname + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
    }
}
