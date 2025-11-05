package org.docencia.hotel.persistence.jpa.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.docencia.hotel.domain.repository.IBookingRepository;
import org.docencia.hotel.model.Booking;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IBookingJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookingJpaRepository extends JpaAbstractRepository<Booking, String> implements IBookingRepository {

    private IBookingJpaRepository repository;

    public BookingJpaRepository(IBookingJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Booking findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ArrayList<Booking> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Booking save(Booking Booking) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArrayList<Booking> findRoomBookings(Room room, LocalDateTime startDate, LocalDateTime endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findRoomBookings'");
    }
}
