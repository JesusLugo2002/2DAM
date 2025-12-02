package org.jesus.polyglot.persistence.jpa.interfaces;

import org.jesus.polyglot.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuestJpaRepository extends JpaRepository<Guest, Integer> {
    
}
