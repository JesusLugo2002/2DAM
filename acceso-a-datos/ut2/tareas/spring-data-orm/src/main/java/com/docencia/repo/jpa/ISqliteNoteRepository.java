package com.docencia.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.model.Note;

public interface ISqliteNoteRepository extends JpaRepository<Note, String> {
        
}
