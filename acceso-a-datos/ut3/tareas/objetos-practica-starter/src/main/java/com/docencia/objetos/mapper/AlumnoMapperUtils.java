package com.docencia.objetos.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.repo.jpa.AlumnoEntity;

public class AlumnoMapperUtils {

    /**
     * Transforma un objeto {@code AlumnoEntity} en un objeto {@code Alumno}
     * 
     * @param alumnoEntity - alumno de entrada como objeto {@code AlumnoEntity}
     * @return Objeto {@code Alumno}
     */
    public static Alumno to(AlumnoEntity alumnoEntity) {
        if (alumnoEntity == null) {
            return null;
        }
        return new Alumno(alumnoEntity.getId(), alumnoEntity.getNombre(), alumnoEntity.getEmail(),
                alumnoEntity.getCiclo());
    }

    /**
     * Transforma un objeto {@code Alumno} en un objeto {@code AlumnoEntity}
     * 
     * @param alumnoEntity - alumno de entrada como objeto {@code Alumno}
     * @return Objeto {@code AlumnoEntity}
     */
    public static AlumnoEntity to(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        return new AlumnoEntity(alumno.getId(), alumno.getNombre(), alumno.getEmail(), alumno.getCiclo());
    }

    /**
     * Transforma una lista de objetos {@code AlumnoEntity} en una lista de
     * {@code Alumno}
     * 
     * @param alumnoEntities - Lista de {@code AlumnoEntity}
     * @return Lista de {@code Alumno}
     */
    public static List<Alumno> to(List<AlumnoEntity> alumnoEntities) {
        List<Alumno> alumnos = new ArrayList<>();
        if (alumnoEntities == null || alumnoEntities.isEmpty()) {
            return alumnos;
        }
        alumnoEntities.forEach((alumnoEntity) -> alumnos.add(to(alumnoEntity)));
        return alumnos;
    }

    public static Optional<Alumno> to(Optional<AlumnoEntity> alumnoEntity) {
        Optional<Alumno> result = Optional.empty();
        if (alumnoEntity == null || alumnoEntity.isEmpty()) {
            return result;
        }
        return result.map(alumno -> to(alumnoEntity).orElse(null));
    }

}
