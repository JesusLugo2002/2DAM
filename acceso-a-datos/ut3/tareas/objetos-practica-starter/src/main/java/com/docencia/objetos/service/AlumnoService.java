package com.docencia.objetos.service;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.repo.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

  private final AlumnoRepository repo;
  public AlumnoService(AlumnoRepository repo){ this.repo = repo; }

  public List<Alumno> listar(){ throw new UnsupportedOperationException("TODO"); }
  public Alumno obtener(Long id){ throw new UnsupportedOperationException("TODO"); }
  public Alumno crear(Alumno a){ throw new UnsupportedOperationException("TODO"); }
  public Alumno actualizar(Long id, Alumno a){ throw new UnsupportedOperationException("TODO"); }
  public void borrar(Long id){ throw new UnsupportedOperationException("TODO"); }

  // TODO: definir excepciones BadRequest/NotFound si se desea
}
