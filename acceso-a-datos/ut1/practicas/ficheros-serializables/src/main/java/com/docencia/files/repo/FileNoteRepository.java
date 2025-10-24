package com.docencia.files.repo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FileNoteRepository extends FileNoteAbstractRepository {

    private String filePath;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    public FileNoteRepository() {
        this.filePath = "note-repository.txt";
        try {
            this.path = verifyFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Si existe y no es un directorio
     * Si no existe lo creo
     * 
     * @throws IOException
     */
    private Path verifyFile() throws IOException {
        URL resourceUrl;
        resourceUrl = getClass().getClassLoader().getResource(filePath);
        if (resourceUrl == null) {
            throw new IOException(filePath + " is not a file or not exists!");
        }
        return Paths.get(resourceUrl.getPath());
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public List<Note> findAll() {
        lock.readLock().lock();
        try {
            return Collections.unmodifiableList(readAllInternal());
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Note save(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private List<Note> readAllInternal() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            boolean fileNotExistsOrIsEmpty = !Files.exists(path) || Files.size(path) == 0;
            if (fileNotExistsOrIsEmpty) return new ArrayList<>();
            Note[] arr = xmlMapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(arr));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }
    @Override
    public Note find(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }
    
}