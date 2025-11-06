package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.repository.IGuestRepository;
import org.docencia.hotel.model.Guest;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IGuestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestJpaRepository extends JpaAbstractRepository<Guest, String> implements IGuestRepository {

    @Autowired
    public GuestJpaRepository(IGuestJpaRepository repository) {
        super(repository);
    }

}
