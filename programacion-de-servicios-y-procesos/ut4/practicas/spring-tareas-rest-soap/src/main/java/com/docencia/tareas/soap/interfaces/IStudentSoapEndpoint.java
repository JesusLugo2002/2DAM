package com.docencia.tareas.soap.interfaces;

import java.util.List;

import com.docencia.tareas.model.Student;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(targetNamespace = "https://jesuslugo2002.github.io/", name = "StudentPortType")
public interface IStudentSoapEndpoint {

    /**
     * Obtain all the tasks.
     * 
     * @return A list with the tasks.
     */
    @WebMethod(operationName = "findAll")
    public List<Student> findAll();
}
