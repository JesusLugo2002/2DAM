package com.docencia.files.repo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import com.docencia.files.model.Note;

public class FileNoteRepository implements IFileNoteRepository {

    private String filePath;
    
    public FileNoteRepository() {
        this.filePath = "note-repository.txt";
        try {
            verifyFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Si existe y no es un directorio
     * Si no existe lo creo
     */
    private boolean verifyFile() throws IOException {
        URL resourceUrl;
        resourceUrl = getClass().getClassLoader().getResource(filePath);
        if (resourceUrl == null) {
            throw new IOException(filePath + " is not a file or not exists!");
        }
        return true;
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Note save(Note n, Optional<String> expOpt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
