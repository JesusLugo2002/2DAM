package com.docencia.tareas.model;

import java.util.Objects;

import jakarta.xml.bind.annotation.*;

/**
 * Class Student.
 * Represents a student.
 * 
 * @author JesusLugo2002
 */
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    private Long identifier;
    private String name;

    /**
     * Empty constructor
     */
    public Student() {
    }

    /**
     * Constructor with ID for queries
     * 
     * @param id - Unique identifier
     */
    public Student(Long id) {
        this.identifier = id;
    }

    /**
     * Constructor with all fields
     * 
     * @param id   - Unique identifier
     * @param name - Student name
     */
    public Student(Long id, String name) {
        this.identifier = id;
        this.name = name;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long id) {
        this.identifier = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (identifier == null) {
            if (other.identifier != null)
                return false;
        } else if (!identifier.equals(other.identifier))
            return false;
        return true;
    }

}
