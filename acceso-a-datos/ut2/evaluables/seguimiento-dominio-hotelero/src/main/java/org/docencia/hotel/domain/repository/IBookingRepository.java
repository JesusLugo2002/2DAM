package org.docencia.hotel.domain.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.docencia.hotel.model.Booking;
import org.docencia.hotel.model.Room;

/**
 * Interface IBookingRepository
 * @author JesusLugo2002
 * Interfaz de repositorio con las operaciones minimas
 * para el dominio de Booking
 */
public interface IBookingRepository {
    /**
     * Comprueba si existe la entidad por id.
     * @param id id del Booking.
     * @return {@code true} si existe, {@code false} si no.
     */
    public boolean exists(String id);

    /**
     * Obtiene una entidad Booking por su id.
     * @param id id del Booking.
     * @return la entidad Booking encontrada, o {@code null} si no existe.
     */
    public Booking findById(String id);

    /**
     * Obtiene la lista de entidades Booking.
     * @return un {@code ArrayList} con todas las reservas.
     */
    public ArrayList<Booking> findAll();

    /**
     * Crea o actualiza la entidad Booking dependiendo si ya existe o no.
     * @param Booking la entidad Booking a guardar/actualizar.
     * @return La entidad Booking guardada/creada.
     */
    public Booking save(Booking Booking);

    /**
     * Elimina la entidad Booking por su id.
     * @param id id del Booking.
     * @return {@code true} si se elimino, si no, {@code false}.
     */
    public boolean delete(String id);
    
    /**
     * Obtiene todas las reservas de una habitacion en concreto 
     * en un rango de fechas determinado.
     * @param room Habitacion a comprobar.
     * @param startDate fecha de inicio.
     * @param endDate fecha de fin.
     * @return Una lista de reservas de la habitacion en el rango de fechas determinado.
     */
    public ArrayList<Booking> findRoomBookings(Room room, LocalDateTime startDate, LocalDateTime endDate);
}
