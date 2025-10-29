package com.docencia.service;

import org.junit.jupiter.api.Test;

import com.docencia.model.Note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class JsonServiceNoteTest {
     JsonServiceNote jsonServiceNote;
    Note note;

    @BeforeEach
    void beforeEach() {
        jsonServiceNote = new JsonServiceNote();
        note = new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");
    }

    @Test
    public void seriablizarNote() {
        String noteStr = jsonServiceNote.noteToString(note);
        Note noteTest = jsonServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest, "Los elementos deben de ser iguales"); 
    }
}
