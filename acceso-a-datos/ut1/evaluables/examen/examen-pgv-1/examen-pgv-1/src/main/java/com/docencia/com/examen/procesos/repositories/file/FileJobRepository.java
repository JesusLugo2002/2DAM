package com.docencia.com.examen.procesos.repositories.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.docencia.com.examen.procesos.repositories.interfaces.JobRepository;

/**
 * Hasta aqui pude llegar profe, tener piedad de esta pobre alma.
 * @author JesusLugo2002
 */
@Repository
public class FileJobRepository implements JobRepository {

    private static final Logger logger = LoggerFactory.getLogger(FileJobRepository.class);
    
    private File directory;
    private String filename;
    
    public FileJobRepository() {
        try {
            this.directory = new File("logs/");
            if (!this.directory.exists()) {
                directory.mkdirs();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public FileJobRepository(String loggerFileName) {
        try {
            this.directory = new File("logs/");
            if (!this.directory.exists()) {
                directory.mkdirs();
            }
            this.filename = loggerFileName;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean createFile(Path filepath) {
        try {
            return new File(filepath.toString()).createNewFile();
        } catch (Exception e) {
            logger.error("Error creating file with path: {}", filepath, e);
        }
        return false;
    }

    public boolean exists(Path filepath) {
        return new File(filepath.toString()).exists();
    }

    @Override
    public boolean add(String content) {
        if (getFilename() == null) setFilename(LocalDate.now().toString());
        Path path = Paths.get(getDirectory() + "/" + getFilename() + ".txt");
        if (!exists(path)) createFile(path);
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))) {
                writer.write(content + "\n");
            } catch (IOException e) {
                logger.warn("Error writing content into logger file", e);
            }
        } catch (Exception e) {
            logger.error("Error creating logger file", e);
        }
        return false;
    }

    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}

