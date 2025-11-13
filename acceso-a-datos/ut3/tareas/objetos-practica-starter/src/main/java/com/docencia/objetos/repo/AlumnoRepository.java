package com.docencia.objetos.repo;

import com.docencia.objetos.domain.Alumno;
import java.util.List;
import java.util.Optional;

public interface AlumnoRepository {
  List<Alumno> findAll();
  Optional<Alumno> findById(Long id);
  Alumno save(Alumno alumno);
  boolean existsByEmail(String email);
  void deleteById(Long id);
  long count();
}
