package dam.jesus.process_cli_application.domain;

import java.io.IOException;

public class Job {
    private String command;

    public Job(String command) {
        setCommand(command);
    }
    
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Process run() {
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", this.getCommand());
        try {
            return processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
