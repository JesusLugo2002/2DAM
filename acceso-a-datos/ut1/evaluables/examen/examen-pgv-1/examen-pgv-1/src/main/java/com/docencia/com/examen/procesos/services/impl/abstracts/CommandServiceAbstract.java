package com.docencia.com.examen.procesos.services.impl.abstracts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.com.examen.procesos.domain.Job;
import com.docencia.com.examen.procesos.repositories.file.FileJobRepository;
import com.docencia.com.examen.procesos.repositories.interfaces.JobRepository;
import com.docencia.com.examen.procesos.services.interfaces.CommandService;

public abstract class CommandServiceAbstract implements CommandService {

    private static final Logger logger = LoggerFactory.getLogger(CommandServiceAbstract.class);

    private Job job;
    private String command;
    private String regex;
    
    private FileJobRepository repository;

    @Override
    public boolean processLine(String command, boolean changeCmd) {
        if (!isValid(command)) return false;
        Process process = execute();
        printOutput(process);
        return true;
    }

    private boolean isValid(String command) {
        String mainCommand = command.split("\\s+")[0];
        if (!mainCommand.toLowerCase().equals(getJob().toString().toLowerCase())) {
            logger.warn("Main command is invalid");
            return false;
        } 
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(command);
        if (!matcher.matches()) {
            logger.warn("Parameters are invalid");
            return false;
        }
        setCommand(command);
        return true;
    }

    private Process execute() {
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", getCommand());
        processBuilder.redirectErrorStream(false);
        try {
            Process process = processBuilder.start();
            return process;
        } catch (Exception e) {
            logger.error("An error happens executing the process", e);
        }
        return null;
    }

    private void printOutput(Process process) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            reader.lines().forEach((line) -> repository.add(line));
        } catch (Exception e) {
            logger.error("Error writing line from process {}", process, e);
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public static Logger getLogger() {
        return logger;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public FileJobRepository getRepository() {
        return repository;
    }

    public void setRepository(FileJobRepository repository) {
        this.repository = repository;
    }

}
