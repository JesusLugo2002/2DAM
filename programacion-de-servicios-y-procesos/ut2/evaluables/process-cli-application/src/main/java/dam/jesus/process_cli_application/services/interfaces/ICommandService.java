package dam.jesus.process_cli_application.services.interfaces;

import dam.jesus.process_cli_application.domain.Job;

public interface ICommandService {
    public boolean setupCommand(String line);
    public boolean validate(String line);
    public boolean runCommand();
    public void printOutput(Job job);
}
