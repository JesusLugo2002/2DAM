package com.docencia.tareas.mapper;

import com.docencia.tareas.model.Student;
import com.docencia.tareas.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-11T17:14:18+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Ubuntu)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Student toStudent(Task task) {
        if ( task == null ) {
            return null;
        }

        Student student = new Student();

        student.setIdentifier( task.getId() );
        student.setName( task.getTitle() );

        return student;
    }

    @Override
    public List<Student> toStudents(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( toStudent( task ) );
        }

        return list;
    }
}
