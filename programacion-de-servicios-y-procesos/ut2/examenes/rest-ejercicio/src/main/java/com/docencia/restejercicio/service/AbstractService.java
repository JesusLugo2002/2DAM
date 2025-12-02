package com.docencia.restejercicio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.restejercicio.repository.interfaces.IEntityRepository;
import com.docencia.restejercicio.repository.interfaces.Identifiable;
import com.docencia.restejercicio.service.interfaces.IEntityService;

@Service
public abstract class AbstractService<Entity extends Identifiable> implements IEntityService<Entity> {

    private IEntityRepository<Entity> repository;

    public void setRepository(IEntityRepository<Entity> repository) {
        this.repository = repository;
    }

    @Override
    public List<Entity> getAll() {
        return repository.findAll();
    }

    @Override
    public Entity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Entity create(Entity entity) {
        return repository.save(entity);
    }

    @Override
    public Entity update(Long id, Entity update) {
        update.setId(id);
        return repository.save(update);
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("The entity don't exists!");
        }
        return repository.deleteById(id);
    }
}
