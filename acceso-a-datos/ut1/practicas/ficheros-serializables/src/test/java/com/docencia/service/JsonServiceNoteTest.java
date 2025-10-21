package com.docencia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.files.model.Note;
import com.docencia.files.service.JsonServiceNote;

class JsonServiceNoteTest {

    JsonServiceNote jsonServiceNote;
    Note note;

    @BeforeEach
    void before() {
        jsonServiceNote = new JsonServiceNote();
        note = new Note("1", "Titulo", "Contenido");
    }

    @Test
    void serialization() {
        String serialized = jsonServiceNote.noteToString(note);
        Note deserialized = jsonServiceNote.stringToNote(serialized);
        Assertions.assertEquals(deserialized, note);
    }

}
