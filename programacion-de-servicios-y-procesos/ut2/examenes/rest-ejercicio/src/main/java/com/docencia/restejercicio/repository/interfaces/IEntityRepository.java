package com.docencia.restejercicio.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface IEntityRepository<Entity> {

    /**
     * Devuelve todos las instancias de la entidad determinada.
     * 
     * @return Una lista con todas las entidades.
     */
    public List<Entity> findAll();

    /**
     * Devuelve un Optional con la instancia encontrada con su id.
     * 
     * @param id - Identificador de la entidad.
     * @return Un Optional de la entidad con su valor, o null si no fue encontrada.
     */
    public Optional<Entity> findById(Long id);

    /**
     * Guarda/actualiza una entidad.
     * 
     * @param newEntity - Entidad a guardar/actualizar.
     * @return La entidad guardada/actualizada.
     */
    public Entity save(Entity newEntity);

    /**
     * Elimina una entidad por su id.
     * 
     * @param id - Identificador de la entidad.
     * @return true si fue eliminada, false si no.
     */
    public boolean deleteById(Long id);

    /**
     * Comprueba que la entidad exista por su id.
     * 
     * @param id - Identificador de la entidad.
     * @return true si se encuentra, false si no.
     */
    public boolean existsById(Long id);

}
