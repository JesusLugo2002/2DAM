package com.docencia.aed.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.aed.entity.PublisherEntity;

@Repository
public interface PublisherJpaRepository extends JpaRepository<PublisherEntity, Integer> {

}
