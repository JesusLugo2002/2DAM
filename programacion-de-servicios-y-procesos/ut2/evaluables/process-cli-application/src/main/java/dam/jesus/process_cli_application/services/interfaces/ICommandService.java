package dam.jesus.process_cli_application.services.interfaces;

import dam.jesus.process_cli_application.domain.Job;

public interface ICommandService {
    public void setupCommand(String line);
    public boolean validate(String line);
    public Job handleCommand();
}
