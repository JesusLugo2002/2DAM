package org.docencia.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @Column(name = "id", nullable = false)
    @NotBlank
    private String id;

    @Column(name = "full_name", nullable = false)
    @NotBlank
    private String fullname;

    @Column(name = "email", nullable = false)
    @NotBlank
    private String email;

    @Column(name = "phone", nullable = false)
    @NotBlank
    private String phoneNumber;

    public Guest() {}

    public Guest(String id, @NotBlank String fullname, @NotBlank String email, @NotBlank String phoneNumber) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
