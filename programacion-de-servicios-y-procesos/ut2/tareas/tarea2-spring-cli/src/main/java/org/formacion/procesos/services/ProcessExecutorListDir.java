package org.formacion.procesos.services;

import org.formacion.procesos.domain.JobType;
import org.formacion.procesos.services.abstracts.ProcessExecutorAbstract;

public class ProcessExecutorListDir extends ProcessExecutorAbstract {

    public ProcessExecutorListDir() {
        setJobType(JobType.LIST_DIR);
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean validate(String[] commandSegments) {
        // TODO Auto-generated method stub
        return false;
    }

}
