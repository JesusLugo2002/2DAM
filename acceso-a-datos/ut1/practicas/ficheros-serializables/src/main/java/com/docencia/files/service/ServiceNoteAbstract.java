package com.docencia.files.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.files.model.Note;
import com.docencia.files.repo.IFileNoteRepository;

public abstract class ServiceNoteAbstract implements IServiceNote {

    @Autowired
    IFileNoteRepository fileNoteRepository;

    public IFileNoteRepository getFileNoteRepository() {
        return this.fileNoteRepository;
    }

}
