package com.docencia.repo.file;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.docencia.model.Note;
import com.docencia.repo.INoteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.common.util.StringUtils;


public abstract class FileNoteAbstractRepository implements INoteRepository {

    private String nameFile;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ObjectMapper mapper;

    public FileNoteAbstractRepository() { }

    public FileNoteAbstractRepository(String nameFile, ObjectMapper mapper) {
        this.nameFile = nameFile;
        path = verificarFichero();
        this.mapper = mapper;
    }

    private Path verificarFichero() {
        URL resource;
        resource = getClass().getClassLoader().getResource(nameFile);
        return Paths.get(resource.getPath());

    }

    private List<Note> readAllInternal() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0)
                return new ArrayList<>();
            Note[] arrayNotes = mapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(arrayNotes));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }

    private void writeAllInternal(List<Note> items) {
        try {
            byte[] bytes = mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(items);
            Files.write(path, bytes,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException("Error escribiendo JSON", e);
        }
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        Note elemento = new Note(id);
        return find(elemento);
    }

    @Override
    public Note find(Note note) {
        List<Note> notes = findAll();
        int posicon = notes.indexOf(note);
        if (posicon < 0 ) {
            return null;
        }
        return notes.get(posicon);
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
       lock.writeLock().lock();
        try {
            List<Note> notes = readAllInternal();
            if (StringUtils.isEmpty(note.getId()))  {
                note.setId(UUID.randomUUID().toString());
            }
            notes.removeIf(n -> Objects.equals(n.getId(), note.getId()));
            notes.add(note);
            writeAllInternal(notes);
            return note;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
