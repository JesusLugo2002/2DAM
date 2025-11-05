package org.docencia.hotel.persistence.jpa.abstracts;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class JpaAbstractRepository<T, ID> implements  {

    private JpaRepository<T, ID> repository;

    public JpaAbstractRepository(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public boolean exists(ID id) {
        return repository.existsById(id);
    }

    public T findById(ID id) {
        return repository.findById(id).orElse(null); 
    }

    public ArrayList<T> findAll() {
        return repository.findAll();
    }
}
