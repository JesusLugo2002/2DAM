package org.jesus.polyglot.domain.repository;

import java.util.List;

import org.jesus.polyglot.domain.repository.shared.GenericRepository;
import org.jesus.polyglot.model.Booking;
import org.jesus.polyglot.model.Room;

public interface BookingRepository extends GenericRepository<Booking, Integer> {
    /**
     * Devuelve una lista con todas las reservas de una habitacion entre fechas
     * determinadas.
     * 
     * @param room     - Habitacion del que se buscaran reservas.
     * @param checkIn  - Fecha minima.
     * @param checkOut - Fecha maxima.
     * @return Una {@code List} con todas las reservas de la habitacion entre las
     *         fechas.
     */
    List<Booking> findByRoomBetweenDates(Room room, String checkIn, String checkOut);
}
