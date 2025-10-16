package org.formacion.procesos.services.abstracts;

import java.util.List;

import org.formacion.procesos.domain.JobType;

public abstract class ProcessExecutorAbstract {
    private JobType jobType;
    private String mainCommand;
    private List<String> parameters;

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
    
    public JobType getJobType() {
        return jobType;
    }

    public String getMainCommand() {
        return mainCommand;
    }

    public void setMainCommand(String mainCommand) {
        this.mainCommand = mainCommand;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }


    public abstract void execute();

    public abstract boolean validate(String[] commandSegments);
}
