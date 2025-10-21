package org.formacion.procesos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    ProcessExecutorLS processExecutorLS;

    @Autowired
    ProcessExecutorPING processExecutorPING;

    public void init(String commandLine) {
        if (commandLine.startsWith("ls")) {
            processExecutorLS.setupCommand(commandLine);
        } else if (commandLine.startsWith("ping")) {
            processExecutorPING.setupCommand(commandLine);
        }
    }

}
