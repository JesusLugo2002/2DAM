package org.docencia.hotel.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @Column(name = "id", nullable = false)
    @NotBlank
    private String id;

    @Column(name = "name", nullable = false)
    @Size(max = 255)
    @NotBlank
    private String name;

    @Column(name = "address", nullable = false)
    @Size(max = 255)
    @NotBlank
    private String address;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(@Size(max = 255) @NotBlank String name, @Size(max = 255) @NotBlank String address) {
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
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
