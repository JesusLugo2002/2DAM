package org.docencia.hotel.persistence.jpa.interfaces;

import org.docencia.hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuestJpaRepository extends JpaRepository<Guest, String> {

}
