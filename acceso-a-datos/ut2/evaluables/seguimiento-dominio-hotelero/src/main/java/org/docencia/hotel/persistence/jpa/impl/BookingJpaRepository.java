package org.docencia.hotel.persistence.jpa.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.docencia.hotel.domain.repository.IBookingRepository;
import org.docencia.hotel.model.Booking;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IBookingJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookingJpaRepository extends JpaAbstractRepository<Booking, String> implements IBookingRepository {

    public BookingJpaRepository(IBookingJpaRepository repository) {
        super(repository);
    }

    @Override
    public List<Booking> findRoomBookings(Room room, LocalDateTime startDate, LocalDateTime endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findRoomBookings'");
    }

    @Override
    public Booking save(Booking booking) {
        if (booking.getId() == null) {
            booking.setId(UUID.randomUUID().toString());
        }
        return getRepository().save(booking);
    }

}
