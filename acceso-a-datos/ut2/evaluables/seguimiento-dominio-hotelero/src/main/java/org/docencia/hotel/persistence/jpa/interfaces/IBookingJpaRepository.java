package org.docencia.hotel.persistence.jpa.interfaces;

import org.docencia.hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingJpaRepository extends JpaRepository<Booking, String> {

}
