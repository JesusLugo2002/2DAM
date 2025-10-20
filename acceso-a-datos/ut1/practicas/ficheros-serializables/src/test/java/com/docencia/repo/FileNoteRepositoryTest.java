package com.docencia.repo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.docencia.files.repo.FileNoteRepository;

class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;

    @Test
    void createFileTest() {
        fileNoteRepository = new FileNoteRepository();
    }
}
