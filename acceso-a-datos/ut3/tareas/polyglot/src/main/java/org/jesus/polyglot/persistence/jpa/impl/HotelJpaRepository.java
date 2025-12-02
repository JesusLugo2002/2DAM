package org.jesus.polyglot.persistence.jpa.impl;

import java.util.Optional;

import org.jesus.polyglot.domain.repository.HotelRepository;
import org.jesus.polyglot.model.Hotel;
import org.jesus.polyglot.persistence.jpa.abstracts.AbstractJpaRepository;
import org.jesus.polyglot.persistence.jpa.interfaces.IHotelJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HotelJpaRepository extends AbstractJpaRepository<Hotel, Integer> implements HotelRepository {

    public HotelJpaRepository(IHotelJpaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Hotel> find(Hotel hotel) {
        return findById(hotel.getId());
    }

    @Override
    public boolean delete(Hotel hotel) {
        return deleteById(hotel.getId());
    }
}
