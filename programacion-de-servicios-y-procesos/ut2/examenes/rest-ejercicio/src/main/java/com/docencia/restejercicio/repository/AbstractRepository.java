package com.docencia.restejercicio.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.docencia.restejercicio.repository.interfaces.IEntityRepository;
import com.docencia.restejercicio.repository.interfaces.Identifiable;

@Repository
public abstract class AbstractRepository<Entity extends Identifiable> implements IEntityRepository<Entity> {

    ArrayList<Entity> entities = new ArrayList<>();
    Long nextId = 1L;

    @Override
    public boolean deleteById(Long id) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId() == id) {
                entities.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        if (id == null)
            return false;
        for (Entity entity : entities) {
            if (entity.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Entity> findAll() {
        return entities;
    }

    @Override
    public Optional<Entity> findById(Long id) {
        for (Entity entity : entities) {
            if (entity.getId() == id) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    @Override
    public Entity save(Entity newEntity) {
        Long id = newEntity.getId();
        if (existsById(id)) {
            deleteById(id);
        } else if (id == null) {
            newEntity.setId(nextId);
            nextId++;
        }
        entities.add(newEntity);
        return findById(newEntity.getId()).get();
    }

}
