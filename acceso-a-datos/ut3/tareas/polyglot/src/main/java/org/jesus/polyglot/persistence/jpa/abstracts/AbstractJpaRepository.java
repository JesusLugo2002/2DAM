package org.jesus.polyglot.persistence.jpa.abstracts;

import java.util.List;
import java.util.Optional;

import org.jesus.polyglot.domain.repository.shared.GenericRepository;
import org.jesus.polyglot.model.generic.Identifiable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractJpaRepository<ENTITY, ID> implements GenericRepository<ENTITY, ID> {

    JpaRepository<ENTITY, ID> repository;

    public AbstractJpaRepository(JpaRepository<ENTITY, ID> repository) {
        this.repository = repository;
    }

    public JpaRepository<ENTITY, ID> getRepository() {
        return repository;
    }

    @Override
    public boolean delete(ENTITY entity) {
        repository.delete(entity);
        return true;
    }

    @Override
    public boolean deleteById(ID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<ENTITY> find(ENTITY entity) {
        // TODO: Implementar Identifiable en Entity para habilitar getId()
        return findById(entity.getId());
    }

    @Override
    public List<ENTITY> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ENTITY> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public ENTITY save(ENTITY entity) {
        ENTITY newEntity = repository.save(entity);
        return newEntity;
    }

}
