package com.docencia.objetos.repo;

import com.docencia.objetos.domain.Alumno;
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
    throw new UnsupportedOperationException("TODO: implementar usando jpa.findAll() y mapear a dominio");
  }

  @Override
  public Optional<Alumno> findById(Long id) {
    throw new UnsupportedOperationException("TODO: implementar usando jpa.findById() y mapear a dominio");
  }

  @Override
  public Alumno save(Alumno alumno) {
    throw new UnsupportedOperationException("TODO: mapear dominio->entidad, jpa.save, entidad->dominio");
  }

  @Override
  public boolean existsByEmail(String email) {
    throw new UnsupportedOperationException("TODO: implementar (método derivado en JPA o consulta)");
  }

  @Override
  public void deleteById(Long id) {
    throw new UnsupportedOperationException("TODO: implementar jpa.deleteById(id)");
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException("TODO: implementar jpa.count()");
  }

  // TODO: métodos de mapeo toDomain/toEntity
}
