package org.jesus.polyglot.persistence.jpa.interfaces;

import java.util.List;

import org.jesus.polyglot.model.Hotel;
import org.jesus.polyglot.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomJpaRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByHotel(Hotel hotel);
}
