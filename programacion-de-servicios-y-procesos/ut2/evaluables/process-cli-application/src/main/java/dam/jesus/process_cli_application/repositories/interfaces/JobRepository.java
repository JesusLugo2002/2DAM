package dam.jesus.process_cli_application.repositories.interfaces;

import java.nio.file.Path;

import dam.jesus.process_cli_application.domain.Job;

public interface JobRepository {
    public boolean createFile(Path filepath);
    public boolean exists(Path filepath);
    public void writeFile(Job job);
}
