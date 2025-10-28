package dam.tareas.jesus.proc_cli_application.domain;

public class Job {
    String mainCommand;
    String parametersRegex;

    public Job() {}

    public Job(String mainCommand, String parametersRegex) {
        this.mainCommand = mainCommand;
        this.parametersRegex = parametersRegex;
    }

    public String getMainCommand() {
        return mainCommand;
    }
    public void setMainCommand(String mainCommand) {
        this.mainCommand = mainCommand;
    }
    public String getParametersRegex() {
        return parametersRegex;
    }
    public void setParametersRegex(String parametersRegex) {
        this.parametersRegex = parametersRegex;
    }

    
}
