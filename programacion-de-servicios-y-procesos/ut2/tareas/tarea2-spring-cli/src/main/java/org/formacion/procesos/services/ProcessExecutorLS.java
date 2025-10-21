package org.formacion.procesos.services;

import org.formacion.procesos.domain.JobType;
import org.formacion.procesos.services.abstracts.ProcessExecutorAbstract;
import org.springframework.stereotype.Service;

@Service
public class ProcessExecutorLS extends ProcessExecutorAbstract {

    public ProcessExecutorLS() {
        this.setJobType(JobType.LS);
        this.setRegex("^((-(la|a|l))|\s*)$");
    }

    @Override
    public void printOutput() {
        System.out.println("[OUTPUT] Command LS executed! :)");
    }    
}
