package com.docencia.objetos.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoJpaRepository extends JpaRepository<AlumnoEntity, Long> {
  boolean existsByEmail(String email);
}
