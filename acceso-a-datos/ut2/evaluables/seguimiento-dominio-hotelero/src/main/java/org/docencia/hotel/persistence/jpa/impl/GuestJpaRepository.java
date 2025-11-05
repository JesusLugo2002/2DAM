package org.docencia.hotel.persistence.jpa.impl;

import java.util.ArrayList;

import org.docencia.hotel.domain.repository.IGuestRepository;
import org.docencia.hotel.model.Guest;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IGuestJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GuestJpaRepository extends JpaAbstractRepository<Guest, String> implements IGuestRepository {

    private IGuestJpaRepository repository;

    public GuestJpaRepository(IGuestJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Guest findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ArrayList<Guest> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Guest save(Guest Guest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
