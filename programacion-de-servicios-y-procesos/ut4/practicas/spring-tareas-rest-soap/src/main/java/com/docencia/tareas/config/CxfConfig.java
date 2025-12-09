package com.docencia.tareas.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.docencia.tareas.soap.TaskSoapService;

import jakarta.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    private final Bus bus;
    private final TaskSoapService taskSoapService;

    public CxfConfig(Bus bus, TaskSoapService taskSoapService) {
        this.bus = bus;
        this.taskSoapService = taskSoapService;
    }

    @Bean
    public Endpoint taskEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, taskSoapService);
        endpoint.publish("/tasks");
        return endpoint;
    }
}
