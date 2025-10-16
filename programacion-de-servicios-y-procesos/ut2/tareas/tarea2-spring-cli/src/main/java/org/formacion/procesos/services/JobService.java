package org.formacion.procesos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    ProcessExecutorListDir processExecutorListDir;

    public void init(String commandLine) {
        String[] commandSegments = commandLine.split(" ");
        switch (commandSegments[0]) {
            case "list_dir":
                processExecutorListDir.execute();
                break;
        
            default:
                break;
        }
    }

}
