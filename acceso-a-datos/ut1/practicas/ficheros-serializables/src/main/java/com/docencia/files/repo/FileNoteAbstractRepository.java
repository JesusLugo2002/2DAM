package com.docencia.files.repo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class FileNoteAbstractRepository implements IFileNoteRepository {

    private String filename;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ObjectMapper mapper;

    public FileNoteAbstractRepository(String filename, ObjectMapper mapper) {
        this.filename = filename;
        this.path = verifyFile();
        this.mapper = mapper;
    }

    /**
     * Si existe y no es un directorio
     * Si no existe lo creo
     * 
     * @throws IOException
     */
    private Path verifyFile() {
        URL resourceUrl;
        resourceUrl = getClass().getClassLoader().getResource(filename);
        return Paths.get(resourceUrl.getPath());
    }


    private List<Note> readAllInternal() {
        try {
            boolean fileNotExistsOrIsEmpty = !Files.exists(path) || Files.size(path) == 0;
            if (fileNotExistsOrIsEmpty) return new ArrayList<>();
            Note[] arr = mapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(arr));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }

}
