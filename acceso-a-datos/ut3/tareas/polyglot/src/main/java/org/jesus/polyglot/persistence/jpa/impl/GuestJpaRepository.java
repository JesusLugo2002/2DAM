package org.jesus.polyglot.persistence.jpa.impl;

import org.jesus.polyglot.domain.repository.GuestRepository;
import org.jesus.polyglot.model.Guest;
import org.jesus.polyglot.persistence.jpa.abstracts.AbstractJpaRepository;
import org.jesus.polyglot.persistence.jpa.interfaces.IGuestJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GuestJpaRepository extends AbstractJpaRepository<Guest, Integer> implements GuestRepository {

    public GuestJpaRepository(IGuestJpaRepository repository) {
        super(repository);
    }
}
