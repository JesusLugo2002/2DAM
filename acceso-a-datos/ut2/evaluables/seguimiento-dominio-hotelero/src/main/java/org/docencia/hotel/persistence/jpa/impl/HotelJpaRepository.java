package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.repository.IHotelRepository;
import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IHotelJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelJpaRepository extends JpaAbstractRepository<Hotel, String> implements IHotelRepository {

    @Autowired
    public HotelJpaRepository(IHotelJpaRepository repository) {
        super(repository);
    }

}
