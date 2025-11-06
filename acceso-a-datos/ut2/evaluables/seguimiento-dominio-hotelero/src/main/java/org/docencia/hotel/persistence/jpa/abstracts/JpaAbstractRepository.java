package org.docencia.hotel.persistence.jpa.abstracts;

import java.util.List;

import org.docencia.hotel.persistence.jpa.interfaces.CrudInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public abstract class JpaAbstractRepository<T, ID> implements CrudInterface<T, ID> {

    private JpaRepository<T, ID> repository;

    public JpaAbstractRepository(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public boolean delete(ID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean exists(ID id) {
        return repository.existsById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }
}
