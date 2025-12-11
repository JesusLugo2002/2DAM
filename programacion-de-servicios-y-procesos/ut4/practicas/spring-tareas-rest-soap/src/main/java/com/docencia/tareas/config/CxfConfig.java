package com.docencia.tareas.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.docencia.tareas.soap.StudentSoapService;
import com.docencia.tareas.soap.TaskSoapService;

import jakarta.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    private final Bus bus;
    private final TaskSoapService taskSoapService;
    private final StudentSoapService studentSoapService;

    public CxfConfig(Bus bus, TaskSoapService taskSoapService, StudentSoapService studentSoapService) {
        this.bus = bus;
        this.taskSoapService = taskSoapService;
        this.studentSoapService = studentSoapService;
    }

    @Bean
    public Endpoint taskEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, taskSoapService);
        endpoint.publish("/tasks");
        return endpoint;
    }

    @Bean
    public Endpoint studentEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, studentSoapService);
        endpoint.publish("/students");
        return endpoint;
    }
}
