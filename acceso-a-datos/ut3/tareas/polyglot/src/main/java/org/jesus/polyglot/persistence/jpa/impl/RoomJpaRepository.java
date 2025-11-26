package org.jesus.polyglot.persistence.jpa.impl;

import java.util.List;

import org.jesus.polyglot.domain.repository.RoomRepository;
import org.jesus.polyglot.model.Hotel;
import org.jesus.polyglot.model.Room;
import org.jesus.polyglot.persistence.jpa.abstracts.AbstractJpaRepository;
import org.jesus.polyglot.persistence.jpa.interfaces.IRoomJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoomJpaRepository extends AbstractJpaRepository<Room, Integer> implements RoomRepository {

    IRoomJpaRepository repository;

    public RoomJpaRepository(IRoomJpaRepository repository) {
        super(repository);
    }

    @Override
    public List<Room> findByHotel(Hotel hotel) {
        return repository.findAllByHotel(hotel);
    }

}
