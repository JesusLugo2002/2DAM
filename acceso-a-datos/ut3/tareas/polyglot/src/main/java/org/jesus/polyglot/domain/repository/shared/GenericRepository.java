package org.jesus.polyglot.domain.repository.shared;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz GenericRepository.
 * Contiene las operaciones basicas que pueden realizar sobre una entidad determinada que haga uso
 * de un tipo de identificador unico determinado.
 * 
 * @param ENTITY - Entidad con la que el repositorio trabaja.
 * @param ID - Tipo del identificador unico cuya entidad utiliza.
 *  
 * @author JesusLugo2002
 */
public interface GenericRepository<ENTITY, ID> {
    /**
     * Comprueba si la entidad existe por su id.
     * @param id - Identificador unico de la entidad.
     * @return {@code true} si existe, {@code false} si no.
     */
    boolean existsById(ID id);

    /**
     * Devuelve la entidad si se encuentra, si no, devuelve {@code null}.
     * @param entity - Entidad a buscar.
     * @return La entidad si es encontrada, si no, {@code null}.
     */
    Optional<ENTITY> find(ENTITY entity);

    /**
     * Devuelve la entidad si se encuentra buscando por su id, si no, devuelve {@code null}.
     * @param id - Identificador unico de la entidad.
     * @return La entidad si es encontrada, si no, {@code null}.
     */
    Optional<ENTITY> findById(ID id);

    /**
     * Devuelve una lista con todas las entidades encontradas.
     * @return Un {@code List} de entidades.
     */
    List<ENTITY> findAll();

    /**
     * Guarda o actualiza una entidad.
     * @param entity - La entidad a guardar/actualizar.
     * @return - La entidad guardada/actualizada.
     */
    ENTITY save(ENTITY entity);

    /**
     * Elimina una entidad.
     * @param entity - Entidad a eliminar.
     * @return {@code true} si la entidad fue eliminada, si no, {@code false}.
     */
    boolean delete(ENTITY entity);

    /**
     * Elimina una entidad en base a su id.
     * @param id - Identificador unico de la entidad a eliminar.
     * @return {@code true} si la entidad fue eliminada, si no, {@code false}.
     */
    boolean deleteById(ID id);
}
