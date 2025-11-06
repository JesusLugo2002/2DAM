package org.docencia.hotel.model;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "id", nullable = false)
    @NotBlank
    private String id;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "type")
    private String type;

    @Column(name = "price_per_night", nullable = false)
    private double pricePerNight;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private ArrayList<Booking> bookings = new ArrayList<>();

    public Room() {
    }

    public Room(String id, int number, String type, double pricePerNight, Hotel hotel, ArrayList<Booking> bookings) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
        this.bookings = bookings;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return this.pricePerNight;
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

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

}
