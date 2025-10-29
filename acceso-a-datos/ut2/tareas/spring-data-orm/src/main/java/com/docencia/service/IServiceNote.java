package com.docencia.service;

import java.util.List;

import com.docencia.model.Note;

public interface IServiceNote {
    public boolean exists(String id);
    public Note findById(String id);
    public List<Note> findAll();
    public Note save(Note note);
    public boolean delete(String id);
    public String noteToString(Note note);
    public Note stringToNote(String data);

}
