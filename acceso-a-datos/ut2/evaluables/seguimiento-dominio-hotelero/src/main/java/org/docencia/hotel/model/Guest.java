package org.docencia.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Guest")
public class Guest {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "fullname", nullable = false)
    @NotBlank
    private String fullname;

    @Column(name = "email", nullable = false)
    @NotBlank
    private Email email;

    @Column(name = "phoneNumber", nullable = false)
    @NotBlank
    private String phoneNumber;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
