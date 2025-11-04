package org.docencia.hotel.domain.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hotel")
@NotBlank
public class Hotel {

    @Id
    @Column(name = "id")
    @NotBlank
    private UUID id;

    @Column(name = "name")
    @Size(max = 255)
    @NotBlank
    private String name;

    @Column(name = "address")
    @Size(max = 255)
    @NotBlank
    private String address;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
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
}
