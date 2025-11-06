package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.repository.IHotelRepository;
import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HotelJpaRepository extends JpaAbstractRepository<Hotel, String> implements IHotelRepository {

    public HotelJpaRepository(JpaRepository<Hotel, String> repository) {
        super(repository);
    }

}
