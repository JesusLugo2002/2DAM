package org.docencia.hotel.domain.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @Column(name = "id")
    @NotBlank
    private UUID id;

    @Column(name = "number")
    @NotBlank
    private int number;

    @Column(name = "type")
    @NotBlank
    private String type;

    @Column(name = "pricePerNight")
    @NotBlank
    private double pricePerNight;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
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

}
