package com.docencia.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.model.Note;

public interface SqliteNoteRepository extends JpaRepository<Note, String> {
    
}
