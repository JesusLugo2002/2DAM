package com.docencia.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.model.Note;
import com.docencia.repo.file.FileNoteRepository;

class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;
    Note elemento;
    Note elementoFind = null;
    String id = "00001";
    String titulo = "Mi titulo";
    String contenido = "contenido";

    @BeforeEach
    void beforeEach() {
        fileNoteRepository = new FileNoteRepository();
        elemento = new Note(id, titulo, contenido);
        elementoFind = fileNoteRepository.find(elemento);
        Assertions.assertNull(elementoFind, "El elemento debe de ser null");
    }

    @AfterEach
    void afterEach() {
        elementoFind = fileNoteRepository.findById(id);
        Assertions.assertNotNull(elementoFind, "El elemento no debe de ser null");

    }

    @Test
    void createFileTest() {
        Assertions.assertNotNull(fileNoteRepository, "El repositorio no debe de ser nulo");
    }

    @Test
    void insertNoteTest() {
        Note result = fileNoteRepository.findById(null);
        Assertions.assertNotNull(result, "El resultado no debe de ser nulo");
        Assertions.assertEquals(result, result, "El valor no es el esperado");
        //getById
        //insert
        //getById
        //delete
    }

}
