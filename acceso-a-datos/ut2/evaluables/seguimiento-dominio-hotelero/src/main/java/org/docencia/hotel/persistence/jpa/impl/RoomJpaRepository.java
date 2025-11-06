package org.docencia.hotel.persistence.jpa.impl;

import java.util.List;

import org.docencia.hotel.domain.repository.IRoomRepository;
import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.model.Room;
import org.docencia.hotel.persistence.jpa.abstracts.JpaAbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoomJpaRepository extends JpaAbstractRepository<Room, String> implements IRoomRepository {

    public RoomJpaRepository(JpaRepository<Room, String> repository) {
        super(repository);
    }

    @Override
    public List<Room> getRoomsByHotel(Hotel hotel) {
        return hotel.getRooms();
    }

}
