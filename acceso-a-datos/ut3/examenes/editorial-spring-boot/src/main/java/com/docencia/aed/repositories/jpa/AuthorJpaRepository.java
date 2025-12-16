package com.docencia.aed.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.aed.entity.AuthorEntity;

@Repository
public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Integer> {
    
}
