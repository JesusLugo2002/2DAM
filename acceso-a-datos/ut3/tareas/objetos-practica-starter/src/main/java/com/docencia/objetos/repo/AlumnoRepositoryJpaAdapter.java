package com.docencia.objetos.repo;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.mapper.AlumnoMapperUtils;
import com.docencia.objetos.repo.jpa.AlumnoEntity;
import com.docencia.objetos.repo.jpa.AlumnoJpaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("h2")
public class AlumnoRepositoryJpaAdapter implements AlumnoRepository {

  private final AlumnoJpaRepository jpa;

  public AlumnoRepositoryJpaAdapter(AlumnoJpaRepository jpa) {
    this.jpa = jpa;
  }

  @Override
  public List<Alumno> findAll() {
    return AlumnoMapperUtils.to(jpa.findAll());
  }

  @Override
  public Optional<Alumno> findById(Long id) {
    return AlumnoMapperUtils.to(jpa.findById(id));
  }

  @Override
  public Alumno save(Alumno alumno) {
    return AlumnoMapperUtils.to(jpa.save(AlumnoMapperUtils.to(alumno)));
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpa.existsByEmail(email);
  }

  @Override
  public boolean deleteById(Long id) {
    jpa.deleteById(id);
    return true;
  }

  @Override
  public long count() {
    return jpa.count();
  }
}
