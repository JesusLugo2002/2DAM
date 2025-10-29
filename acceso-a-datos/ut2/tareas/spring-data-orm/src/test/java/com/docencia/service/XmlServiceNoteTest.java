package com.docencia.service;

import org.junit.jupiter.api.Test;

import com.docencia.model.Note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class XmlServiceNoteTest {
    XmlServiceNote xmlServiceNote;
    Note note;

    @BeforeEach
    void beforeEach() {
        xmlServiceNote = new XmlServiceNote();
        note = new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");
    }

    @Test
    public void seriablizarNote() {
        String noteStr = xmlServiceNote.noteToString(note);
        Note noteTest = xmlServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest, "Los elementos deben de ser iguales"); 
    }
}
