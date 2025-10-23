package org.formacion.procesos.repositories;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.formacion.procesos.repositories.interfaces.CrudInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository implements CrudInterface {
    
    private static Logger logger = LoggerFactory.getLogger(FileRepository.class);
    String filename;
    Path path;

    public FileRepository() {
        this.filename = "mis_procesos.txt";
        this.path = Paths.get(filename);
    }

    @Override
    public boolean add(String text) {
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            logger.error("Se ha producido un error almacenando en el fichero ", e);
        }
        return false;
    }

}
