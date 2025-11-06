package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.repository.IGuestRepository;
import org.docencia.hotel.model.Guest;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GuestJpaRepository extends JpaAbstractRepository<Guest, String> implements IGuestRepository {

    public GuestJpaRepository(JpaRepository<Guest, String> repository) {
        super(repository);
    }

}
