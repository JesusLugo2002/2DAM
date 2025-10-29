package dam.jesus.process_cli_application.repositories.interfaces;

public interface JobRepository {
    public void writeOutput(String[] lines);
    public void writeError(String[] lines);
}
