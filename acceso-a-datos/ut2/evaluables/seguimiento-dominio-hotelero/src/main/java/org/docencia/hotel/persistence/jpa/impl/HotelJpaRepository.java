package org.docencia.hotel.persistence.jpa.impl;

import java.util.UUID;

import org.docencia.hotel.domain.repository.IHotelRepository;
import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IHotelJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HotelJpaRepository extends JpaAbstractRepository<Hotel, String> implements IHotelRepository {

    public HotelJpaRepository(IHotelJpaRepository repository) {
        super(repository);
    }

    @Override
    public Hotel save(Hotel hotel) {
        if (hotel.getId() == null) {
            hotel.setId(UUID.randomUUID().toString());
        }
        return getRepository().save(hotel);
    }

}
