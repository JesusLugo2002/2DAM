package com.docencia.aed.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Class Publisher.
 * Represents a book publisher with name and city.
 * 
 * @author JesusLugo2002
 */
@Entity
@Table(name = "publisher")
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city")
    private String city;

    /**
     * Empty constructor
     */
    public PublisherEntity() {
    }

    /**
     * Constructor with id for queries.
     * 
     * @param id - Unique identifier.
     */
    public PublisherEntity(int id) {
        this.id = id;
    }

    /**
     * Constructor with all fields.
     * 
     * @param id   - Unique identifier.
     * @param name - Publisher name.
     * @param city - Publisher city.
     */
    public PublisherEntity(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PublisherEntity other = (PublisherEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
