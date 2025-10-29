package dam.jesus.process_cli_application.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dam.jesus.process_cli_application.domain.Job;
import dam.jesus.process_cli_application.services.interfaces.ICommandService;

public abstract class CommandServiceAbstract implements ICommandService {
    private Job job;
    private String regex;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getRegex() {
        return regex;
    }
    
    public void setRegex(String regex) {
        this.regex = regex;
    }

    public void setupCommand(String line) {
        if (!validate(line)) {
            System.out.println("[ERROR] Invalid command or parameters");
        } else {
            setJob(new Job(line));
            this.handleCommand();
        }
    }

    public boolean validate(String line) {
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public abstract Job handleCommand();
}
