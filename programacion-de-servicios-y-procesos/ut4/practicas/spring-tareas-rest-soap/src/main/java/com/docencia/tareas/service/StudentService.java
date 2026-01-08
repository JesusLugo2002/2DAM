package com.docencia.tareas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.tareas.mapper.TaskMapper;
import com.docencia.tareas.model.Student;
import com.docencia.tareas.repositories.interfaces.ITaskRepository;
import com.docencia.tareas.service.interfaces.IStudentService;

@Service
public class StudentService implements IStudentService {

    ITaskRepository repository;

    public StudentService(ITaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> listAll() {
        return TaskMapper.INSTANCE.toStudents(repository.findAll());
    }
    
}
