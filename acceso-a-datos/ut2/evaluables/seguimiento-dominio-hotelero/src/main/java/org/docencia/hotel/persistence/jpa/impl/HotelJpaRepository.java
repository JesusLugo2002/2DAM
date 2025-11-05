package org.docencia.hotel.persistence.jpa.impl;

import java.util.ArrayList;

import org.docencia.hotel.domain.repository.IHotelRepository;
import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IHotelJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HotelJpaRepository extends JpaAbstractRepository<Hotel, String> implements IHotelRepository {

    private IHotelJpaRepository repository;

    public HotelJpaRepository(IHotelJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Hotel> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Hotel findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Hotel save(Hotel hotel) {
        // TODO Auto-generated method stub
        return null;
    }


    
    
}
