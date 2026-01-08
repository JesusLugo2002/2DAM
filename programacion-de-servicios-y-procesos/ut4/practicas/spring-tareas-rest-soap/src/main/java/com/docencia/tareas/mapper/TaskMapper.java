package com.docencia.tareas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.docencia.tareas.model.Student;
import com.docencia.tareas.model.Task;

@Mapper
public interface TaskMapper {
    
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mappings({
        @Mapping(source = "id", target = "identifier"),
        @Mapping(source = "title", target = "name")
    })
    Student toStudent(Task task);

    List<Student> toStudents(List<Task> tasks);
}
