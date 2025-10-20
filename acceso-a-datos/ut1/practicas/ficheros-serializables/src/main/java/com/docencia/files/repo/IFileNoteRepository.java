package com.docencia.files.repo;

import java.util.List;
import java.util.Optional;

import com.docencia.files.model.Note;

public interface IFileNoteRepository {
    public boolean exists(String id);
    public Note findById(String id);
    public List<Note> findAll();
    public Note save(Note n, Optional<String> expOpt);
    public void delete(String id);
}
