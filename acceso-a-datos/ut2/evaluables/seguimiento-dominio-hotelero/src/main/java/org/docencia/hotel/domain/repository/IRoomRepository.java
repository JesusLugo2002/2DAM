package org.docencia.hotel.domain.repository;

import java.util.List;

import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.model.Room;

/**
 * Interface IRoomRepository
 * @author JesusLugo2002
 * Interfaz de repositorio con las operaciones minimas
 * para el dominio de Room
 */
public interface IRoomRepository {
    /**
     * Comprueba si existe la entidad por id.
     * @param id id del Room.
     * @return {@code true} si existe, {@code false} si no.
     */
    public boolean exists(String id);

    /**
     * Obtiene una entidad Room por su id.
     * @param id id del Room.
     * @return la entidad Room encontrada, o {@code null} si no existe.
     */
    public Room findById(String id);

    /**
     * Obtiene la lista de entidades Room.
     * @return un {@code List} con todas las habitaciones.
     */
    public List<Room> findAll();

    /**
     * Crea o actualiza la entidad Room dependiendo si ya existe o no.
     * @param Room la entidad Room a guardar/actualizar.
     * @return La entidad Room guardada/creada.
     */
    public Room save(Room Room);

    /**
     * Elimina la entidad Room por su id.
     * @param id id del Room.
     * @return {@code true} si se elimino, si no, {@code false}.
     */
    public boolean delete(String id);

    /**
     * Obtiene todas las habitaciones de un hotel concreto.
     * @param hotel Entidad Hotel donde se extraeran sus habitaciones.
     * @return Un {@code List} con todas las habitaciones del hotel.
     */
    public List<Room> getRoomsByHotel(Hotel hotel);
}
