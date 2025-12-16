package com.docencia.aed.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Class Book
 * Represents a book with title, publication year and author.
 * 
 * @author JesusLugo2002
 */
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publication_year")
    private String publicationYear;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    /**
     * Empty constructor.
     */
    public BookEntity() {
    }

    /**
     * Constructor with id for queries.
     * 
     * @param id - Unique identifier.
     */
    public BookEntity(int id) {
        this.id = id;
    }

    /**
     * Constructor with all fields.
     * 
     * @param id               - Unique identifier.
     * @param title            - Book title
     * @param publication_year - Book release year.
     * @param author_id        - Author.
     */
    public BookEntity(int id, String title, String publication_year, AuthorEntity author) {
        this.id = id;
        this.title = title;
        this.publicationYear = publication_year;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publication_year) {
        this.publicationYear = publication_year;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
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
        BookEntity other = (BookEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
