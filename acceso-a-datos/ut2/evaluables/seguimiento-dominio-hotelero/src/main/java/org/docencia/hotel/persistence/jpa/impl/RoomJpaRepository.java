package org.docencia.hotel.persistence.jpa.impl;

import java.util.List;

import org.docencia.hotel.domain.repository.IRoomRepository;
import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.docencia.hotel.persistence.jpa.interfaces.IRoomJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomJpaRepository extends JpaAbstractRepository<Room, String> implements IRoomRepository {

    @Autowired
    public RoomJpaRepository(IRoomJpaRepository repository) {
        super(repository);
    }

    @Override
    public List<Room> getRoomsByHotel(Hotel hotel) {
        return hotel.getRooms();
    }

}
