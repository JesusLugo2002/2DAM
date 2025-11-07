package org.docencia.hotel.persistence.jpa.interfaces;

import org.docencia.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomJpaRepository extends JpaRepository<Room, String> {

}
