package com.docencia.tareas.soap;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.tareas.model.Student;
import com.docencia.tareas.service.interfaces.IStudentService;
import com.docencia.tareas.soap.interfaces.IStudentSoapEndpoint;

import jakarta.jws.WebService;

@WebService(serviceName = "StudentService", portName = "StudentPort", targetNamespace = "https://jesuslugo2002.github.io/", endpointInterface = "com.docencia.tareas.soap.interfaces.IStudentSoapEndpoint")
@Service
public class StudentSoapService implements IStudentSoapEndpoint {

    private final IStudentService service;

    public StudentSoapService(IStudentService service) {
        this.service = service;
    }

    @Override
    public List<Student> findAll() {
        return service.listAll();
    }

}
