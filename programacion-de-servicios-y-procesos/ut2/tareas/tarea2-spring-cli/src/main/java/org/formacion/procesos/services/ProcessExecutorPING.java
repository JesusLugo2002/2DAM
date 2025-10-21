package org.formacion.procesos.services;

import org.formacion.procesos.domain.JobType;
import org.formacion.procesos.services.abstracts.ProcessExecutorAbstract;
import org.springframework.stereotype.Service;

@Service
public class ProcessExecutorPING extends ProcessExecutorAbstract {

    public ProcessExecutorPING() {
        this.setJobType(JobType.PING);
    }

    @Override
    public void printOutput() {
        System.out.println("[OUTPUT] Command PING executed! :)");
    }

    @Override
    public boolean validate(String[] commandSegments) {
        if (!super.validateMainCommand()) {
            return false;
        }
        return true;
    }

}
