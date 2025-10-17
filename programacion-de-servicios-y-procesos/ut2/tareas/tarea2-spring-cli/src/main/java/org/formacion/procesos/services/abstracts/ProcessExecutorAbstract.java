package org.formacion.procesos.services.abstracts;

import java.util.List;

import org.formacion.procesos.domain.JobType;

public abstract class ProcessExecutorAbstract {
    private String mainCommand;
    private List<String> parameters;
    private JobType jobType;

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

    public JobType getJobType() {
        if (jobType == null) {
            System.out.println("[ERROR] JobType not specified!");
        }
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void setupCommand(String commandLine) {
        String[] commandSegments = commandLine.split(" ");
        setMainCommand(commandSegments[0]);
        if (!validate(commandSegments)) {
            System.out.println("[ERROR] Invalid parameters.");
        }
        
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", commandLine + "> mis_procesos.txt");
        execute(processBuilder);
        printOutput();
    }

    public boolean execute(ProcessBuilder processBuilder) {
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public abstract void printOutput();

    public abstract boolean validate(String[] commandSegments);

    public boolean validateMainCommand() {
        boolean isValid = getMainCommand().toUpperCase().equals(getJobType().toString());
        if (!isValid) {
            System.out.println("[ERROR] Main command invalid.");
        }
        return isValid;
    }    
}
