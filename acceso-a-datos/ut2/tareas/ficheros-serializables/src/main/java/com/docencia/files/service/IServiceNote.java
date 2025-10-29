package com.docencia.files.service;

import java.util.List;
import java.util.Optional;

import com.docencia.files.model.Note;

public interface IServiceNote {
    public boolean exists(String id);
    public Note findById(String id);
    public List<Note> findAll();
    public Note save(Note note, Optional<String> expOpt);
    public void delete(String id);
    public String noteToString(Note note);
    public Note stringToNote(String data);
}
