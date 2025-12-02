package com.docencia.restejercicio.service.interfaces;

import java.util.List;

public interface IEntityService<Entity> {

    /**
     * Devuelve todas las entidades.
     * 
     * @return Lista de entidades.
     */
    List<Entity> getAll();

    /**
     * Devuelve una entidad por su id.
     * 
     * @param id - Identificador de la entidad.
     * @return La entidad encontrada.
     */
    Entity getById(Long id);

    /**
     * Crea una nueva entidad.
     * 
     * @param Entity - Entidad a crear.
     * @return Entidad creada.
     */
    Entity create(Entity Entity);

    /**
     * Actualiza una entidad.
     * 
     * @param id     - Identificador de la entidad.
     * @param update - Informacion a actualizar.
     * @return Entidad actualizada.
     */
    Entity update(Long id, Entity update);

    /**
     * Elimina una entidad.
     * 
     * @param id - Identificador de la entidad.
     * @return True si la entidad fue eliminada, false si no.
     */
    boolean delete(Long id);

}