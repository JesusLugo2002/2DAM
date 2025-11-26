package org.jesus.polyglot.persistence.jpa.impl;

import java.util.List;
import java.util.Optional;

import org.jesus.polyglot.domain.repository.BookingRepository;
import org.jesus.polyglot.model.Booking;
import org.jesus.polyglot.model.Room;
import org.jesus.polyglot.persistence.jpa.abstracts.AbstractJpaRepository;
import org.jesus.polyglot.persistence.jpa.interfaces.IBookingJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookingJpaRepository extends AbstractJpaRepository<Booking, Integer> implements BookingRepository {
    
    IBookingJpaRepository repository;

    public BookingJpaRepository(IBookingJpaRepository repository) {
        super(repository);
    }
    @Override
    public Optional<Booking> find(Booking booking) {
        return findById(booking.getId());
    }

    @Override
    public boolean delete(Booking entity) {
        return deleteById(entity.getId());
    }
    
    @Override
    public List<Booking> findByRoomBetweenDates(Room room, String checkIn, String checkOut) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByRoomBetweenDates'");
    }

}
