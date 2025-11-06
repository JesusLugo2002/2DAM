package org.docencia.hotel.persistence.jpa.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.docencia.hotel.domain.repository.IBookingRepository;
import org.docencia.hotel.model.Booking;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IBookingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingJpaRepository extends JpaAbstractRepository<Booking, String> implements IBookingRepository {

    @Autowired
    public BookingJpaRepository(IBookingJpaRepository repository) {
        super(repository);
    }

    @Override
    public List<Booking> findRoomBookings(Room room, LocalDateTime startDate, LocalDateTime endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findRoomBookings'");
    }

}
