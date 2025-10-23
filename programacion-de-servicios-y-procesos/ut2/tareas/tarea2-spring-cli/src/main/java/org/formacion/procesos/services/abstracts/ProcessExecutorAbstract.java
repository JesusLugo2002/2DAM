package org.formacion.procesos.services.abstracts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.formacion.procesos.domain.JobType;
import org.formacion.procesos.repositories.interfaces.CrudInterface;

public abstract class ProcessExecutorAbstract {

    CrudInterface fileRepository;

    private String mainCommand;
    private JobType jobType;
    private String regex;

    public CrudInterface getFileRepository() {
        return fileRepository;
    }

    public void setFileRepository(CrudInterface fileRepository) {
        this.fileRepository = fileRepository;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getMainCommand() {
        return mainCommand;
    }

    public void setMainCommand(String mainCommand) {
        this.mainCommand = mainCommand;
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
        String[] commandSegments = commandLine.split("\s+");
        this.setMainCommand(commandSegments[0]);
        if (!validate(commandSegments)) {
            System.out.println("[ERROR] Invalid parameters.");
        }
            
        /**
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", commandLine + "> mis_procesos.txt");
        execute(processBuilder);
        printOutput();
         */
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

    public boolean validate(String[] commandSegments) {
        if (!validateMainCommand()) return false;
        if (commandSegments.length == 1) return true;
        String parameter = commandSegments[1]; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parameter);
        if (!matcher.find()) {
            return false;
        }
        return true;
    }

    public boolean validateMainCommand() {
        boolean isValid = getMainCommand().toUpperCase().equals(getJobType().toString());
        if (!isValid) {
            System.out.println("[ERROR] Main command invalid.");
        }
        return isValid;
    }    
}
