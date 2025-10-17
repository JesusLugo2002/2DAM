package org.formacion.procesos.services;

import org.formacion.procesos.domain.JobType;
import org.formacion.procesos.services.abstracts.ProcessExecutorAbstract;
import org.springframework.stereotype.Service;

@Service
public class ProcessExecutorLS extends ProcessExecutorAbstract {

    public ProcessExecutorLS() {
        this.setJobType(JobType.LS);
    }

    @Override
    public void printOutput() {
        System.out.println("[OUTPUT] Command LS executed! :)");
    }

    @Override
    public boolean validate(String[] commandSegments) {
        if (!super.validateMainCommand()) {
            return false;
        }
        return true;
    }
    
}
