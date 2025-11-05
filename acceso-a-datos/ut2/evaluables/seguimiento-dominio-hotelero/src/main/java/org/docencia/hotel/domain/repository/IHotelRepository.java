package org.docencia.hotel.domain.repository;

import java.util.ArrayList;

import org.docencia.hotel.model.Hotel;

/**
 * Interface IHotelRepository
 * @author JesusLugo2002
 * Interfaz de repositorio con las operaciones minimas
 * para el dominio de Hotel
 */
public interface IHotelRepository {
    /**
     * Comprueba si existe la entidad por id.
     * @param id id del hotel.
     * @return {@code true} si existe, {@code false} si no.
     */
    public boolean exists(String id);

    /**
     * Obtiene una entidad Hotel por su id.
     * @param id id del hotel.
     * @return la entidad Hotel encontrada, o {@code null} si no existe.
     */
    public Hotel findById(String id);

    /**
     * Obtiene la lista de entidades Hotel.
     * @return un {@code ArrayList} con todos los hoteles.
     */
    public ArrayList<Hotel> findAll();

    /**
     * Crea o actualiza la entidad Hotel dependiendo si ya existe o no.
     * @param hotel la entidad Hotel a guardar/actualizar.
     * @return La entidad Hotel guardada/creada.
     */
    public Hotel save(Hotel hotel);

    /**
     * Elimina la entidad Hotel por su id.
     * @param id id del hotel.
     * @return {@code true} si se elimino, si no, {@code false}.
     */
    public boolean delete(String id);
}
