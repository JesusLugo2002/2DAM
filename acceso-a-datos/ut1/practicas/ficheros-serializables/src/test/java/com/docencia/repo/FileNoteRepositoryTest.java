package com.docencia.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.files.model.Note;
import com.docencia.files.repo.FileNoteRepository;


class FileNoteRepositoryTest {

    static FileNoteRepository fileNoteRepository;
    static Note item;
    static Note itemFound = null;
    static String id = "00001";
    static String title = "My title";
    static String content = "My content";

    @BeforeEach
    static void beforeEach() {
        fileNoteRepository = new FileNoteRepository();
        item = new Note(id, title, content);
        itemFound = fileNoteRepository.find(item);
        Assertions.assertNull(itemFound, "The repository must be initialized empty!");
    }

    @AfterEach
    static void afterEach() {
        itemFound = fileNoteRepository.findById(id);
        Assertions.assertNull(itemFound, "The repository must be initialized empty!");
    }

    @Test
    void createFileTest() {
        Assertions.assertNotNull(fileNoteRepository, "The repository must be not null!");
    }

    @Test
    void insertNoteTest() {
        Note result = fileNoteRepository.findById(null);
        Assertions.assertNotNull(result, "The result must be not null!");
        Assertions.assertEquals(result, result, "The value not is expected!");
    }
}
