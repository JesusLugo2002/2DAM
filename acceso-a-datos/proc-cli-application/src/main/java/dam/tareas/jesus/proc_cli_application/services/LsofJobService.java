package dam.tareas.jesus.proc_cli_application.services;

import org.springframework.stereotype.Service;

import dam.tareas.jesus.proc_cli_application.domain.JobType;

@Service
public class LsofJobService {
    private JobType jobType;
    private String regex;

    public LsofJobService() {
        this.setJobType(JobType.LSOF);
        this.setRegex("(?:-i)?");
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public void handleCommand(String line) {
        this.validate(line);
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    private boolean validate(String line) {
        String[] commandSegments = line.split("\s+");
        if (!mainCommandIsValid(commandSegments[0])) {
            System.out.println("[ERROR] Invalid main commmand!");
            return false;
        }
        if (commandSegments.length > 1 && !commandSegments[1].matches(getRegex())) {
            System.out.println("[ERROR] Invalid parameters!");
            return false;
        }
        return true;
    }

    private boolean mainCommandIsValid(String command) {
        return getJobType().toString().equals(command.toUpperCase());
    }

}
