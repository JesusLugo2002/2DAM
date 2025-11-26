package org.jesus.polyglot.persistence.jpa.interfaces;

import java.util.List;

import org.jesus.polyglot.model.Booking;
import org.jesus.polyglot.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingJpaRepository extends JpaRepository<Booking, Integer> {
    // TODO: Terminar query
    @Query("SELECT * FROM Booking WHERE")
    List<Booking> findByRoomBetweenDates(Room room, String checkIn, String checkOut);
}
