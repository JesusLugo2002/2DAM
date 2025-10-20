package com.docencia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.files.model.Note;
import com.docencia.files.service.XmlServiceNote;

class XmlServiceNoteTest {

    XmlServiceNote xmlServiceNote;
    Note note;

    @BeforeEach
    void beforeEach() {
        xmlServiceNote = new XmlServiceNote();
        note = new Note("1", "Titulo", "Contenido");
    }

    @Test
    void serializeNote() {
        String noteStr = xmlServiceNote.noteToString(note);
        Note noteTest = xmlServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest, "The objects need to be equals!");
    }

    @Test
    void deserializeNote() {
        
    }
}
