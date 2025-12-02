package org.jesus.polyglot.persistence.jpa.interfaces;


import org.jesus.polyglot.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingJpaRepository extends JpaRepository<Booking, Integer> {
    // List<Booking> findByRoomBetweenDates(Room room, String checkIn, String checkOut);
}
