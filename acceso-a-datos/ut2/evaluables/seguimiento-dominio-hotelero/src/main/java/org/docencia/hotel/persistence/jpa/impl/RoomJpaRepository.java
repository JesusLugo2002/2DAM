package org.docencia.hotel.persistence.jpa.impl;

import java.util.ArrayList;

import org.docencia.hotel.domain.repository.IRoomRepository;
import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.interfaces.IRoomJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoomJpaRepository implements IRoomRepository {

    private IRoomJpaRepository repository;

    public RoomJpaRepository(IRoomJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Room> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Room findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Room> getRoomsByHotel(Hotel hotel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Room save(Room Room) {
        // TODO Auto-generated method stub
        return null;
    }

}
