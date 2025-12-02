package org.jesus.polyglot.persistence.jpa.interfaces;

import org.jesus.polyglot.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelJpaRepository extends JpaRepository<Hotel, Integer> {

}
