package org.docencia.hotel.persistence.jpa.impl;

import java.util.UUID;

import org.docencia.hotel.domain.repository.IGuestRepository;
import org.docencia.hotel.model.Guest;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IGuestJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GuestJpaRepository extends JpaAbstractRepository<Guest, String> implements IGuestRepository {

    public GuestJpaRepository(IGuestJpaRepository repository) {
        super(repository);
    }

    @Override
    public Guest save(Guest guest) {
        if (guest.getId() == null) {
            guest.setId(UUID.randomUUID().toString());
        }
        return getRepository().save(guest);
    }

}
