package org.docencia.hotel.persistence.jpa.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.docencia.hotel.domain.repository.IBookingRepository;
import org.docencia.hotel.model.Booking;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookingJpaRepository extends JpaAbstractRepository<Booking, String> implements IBookingRepository {

    public BookingJpaRepository(JpaRepository<Booking, String> repository) {
        super(repository);
    }

    @Override
    public List<Booking> findRoomBookings(Room room, LocalDateTime startDate, LocalDateTime endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findRoomBookings'");
    }

}
