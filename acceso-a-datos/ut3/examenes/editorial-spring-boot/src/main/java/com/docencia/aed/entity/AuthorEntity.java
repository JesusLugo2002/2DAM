package com.docencia.aed.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Class Author.
 * Represents an author with name, country and books.
 * 
 * @author JesusLugo2002
 */
@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "author")
    private List<BookEntity> books;

    /**
     * Empty constructor.
     */
    public AuthorEntity() {
    }

    /**
     * Constructor with id for queries.
     * 
     * @param id - Unique identifier.
     */
    public AuthorEntity(int id) {
        this.id = id;
    }

    /**
     * Constructor with all fields.
     * 
     * @param id      - Unique identifier
     * @param name    - Author name.
     * @param country - Author country.
     * @param books   - Author books.
     */
    public AuthorEntity(int id, String name, String country, List<BookEntity> books) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.books = books;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
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
        AuthorEntity other = (AuthorEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
