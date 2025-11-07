package org.docencia.hotel.persistence.jpa.interfaces;

import org.docencia.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelJpaRepository extends JpaRepository<Hotel, String> {

}
