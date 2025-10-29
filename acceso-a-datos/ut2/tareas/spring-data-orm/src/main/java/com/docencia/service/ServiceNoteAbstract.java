package com.docencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.model.Note;
import com.docencia.repo.INoteRepository;

public abstract class ServiceNoteAbstract implements IServiceNote {

    @Autowired
    INoteRepository noteRepository;

    public INoteRepository getNoteRepository() {
        return noteRepository;
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    

    
}
