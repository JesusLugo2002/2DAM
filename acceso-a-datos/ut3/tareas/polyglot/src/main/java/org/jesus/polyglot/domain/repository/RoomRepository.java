package org.jesus.polyglot.domain.repository;

import java.util.List;

import org.jesus.polyglot.domain.repository.shared.GenericRepository;
import org.jesus.polyglot.model.Hotel;
import org.jesus.polyglot.model.Room;

public interface RoomRepository extends GenericRepository<Room, Integer> {
    /**
     * Devuelve las habitaciones de un hotel determinado.
     * 
     * @param hotel - Hotel del que se extraeran sus habitaciones.
     * @return Un {@code List} con todas las habitaciones del hotel.
     */
    List<Room> findByHotel(Hotel hotel);
}
