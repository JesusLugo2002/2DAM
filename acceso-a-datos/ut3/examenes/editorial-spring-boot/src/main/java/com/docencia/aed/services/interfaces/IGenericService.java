package com.docencia.aed.services.interfaces;

import java.util.List;

public interface IGenericService<Entity, Id> {

    /**
     * Get all entities.
     * @return List of entities.
     */
    public List<Entity> findAll();

    /**
     * Find an entity by id.
     * @param id - Entity unique identifier.
     * @return Entity found.
     */
    public Entity findById(Id id);

    /**
     * Create a new entity.
     * @param entity - Entity to create.
     * @return Created entity.
     */
    public Entity create(Entity entity);

}
