package org.docencia.hotel.domain.repository;

import java.util.List;

import org.docencia.hotel.model.Guest;

/**
 * Interface IGuestRepository
 * @author JesusLugo2002
 * Interfaz de repositorio con las operaciones minimas
 * para el dominio de Guest
 */
public interface IGuestRepository {
    /**
     * Comprueba si existe la entidad por id.
     * @param id id del Guest.
     * @return {@code true} si existe, {@code false} si no.
     */
    public boolean exists(String id);

    /**
     * Obtiene una entidad Guest por su id.
     * @param id id del Guest.
     * @return la entidad Guest encontrada, o {@code null} si no existe.
     */
    public Guest findById(String id);

    /**
     * Obtiene la lista de entidades Guest.
     * @return un {@code ArrayList} con todos los huespedes.
     */
    public List<Guest> findAll();

    /**
     * Crea o actualiza la entidad Guest dependiendo si ya existe o no.
     * @param Guest la entidad Guest a guardar/actualizar.
     * @return La entidad Guest guardada/creada.
     */
    public Guest save(Guest Guest);

    /**
     * Elimina la entidad Guest por su id.
     * @param id id del Guest.
     * @return {@code true} si se elimino, si no, {@code false}.
     */
    public boolean delete(String id);
}
