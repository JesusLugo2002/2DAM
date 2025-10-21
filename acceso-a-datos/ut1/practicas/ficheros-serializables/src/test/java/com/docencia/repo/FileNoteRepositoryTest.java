package com.docencia.repo;

import org.junit.jupiter.api.Test;

import com.docencia.files.repo.FileNoteRepository;

class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;

    @Test
    void createFileTest() {
        fileNoteRepository = new FileNoteRepository();
    }
}
