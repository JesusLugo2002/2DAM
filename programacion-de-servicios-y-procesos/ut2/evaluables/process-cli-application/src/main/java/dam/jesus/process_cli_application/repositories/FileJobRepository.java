package dam.jesus.process_cli_application.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import dam.jesus.process_cli_application.domain.Job;
import dam.jesus.process_cli_application.repositories.interfaces.JobRepository;

/**
 * Clase FileJobRepository
 * @author JesusLugo2002
 * Repositorio encargado de crear y escribir los logs contenedores
 * de las salidas de los procesos ejecutados en el programa.
 */
@Repository
public class FileJobRepository implements JobRepository {

    private static Logger logger = LoggerFactory.getLogger(FileJobRepository.class);
    private File directory;

    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }

    public FileJobRepository() {
        this.directory = new File("logs/");
        if (!this.directory.exists()) {
            directory.mkdirs();
        }
    }

    public boolean createFile(Path filepath) {
        try {
            return new File(filepath.toString()).createNewFile();
        } catch (IOException e) {
            logger.error("Error creating file with path: {}", filepath, e);
        }
        return false;
    }

    public boolean exists(Path filepath) {
        return new File(filepath.toString()).exists();
    }

    public void writeFile(Job job) {
        Process process = job.getProcess();
        if (process == null) {
            logger.error("The process was not executed!");
            return;
        }
        Path path = Paths.get(getDirectory() + "/" + job.getId() + ".txt");
        if (!exists(path)) createFile(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))) {
            job.getOutLines().forEach(line -> {
                try {
                    writer.write(line + "\n");
                } catch (IOException e) {
                    logger.error("Error while writing stdout!", e);
                }
            });
            job.getErrLines().forEach(line -> {
                try {
                    writer.write(line + "\n");
                } catch (IOException e) {
                    logger.error("Error while writing stderr!", e);
                }
            });
        } catch (IOException e) {
            logger.error("Error writing on file {}", path, e);
        }
    }

}
