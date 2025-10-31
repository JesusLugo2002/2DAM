package com.docencia.repo;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class NoteJpaRepositoryTest {

    @Autowired
    private INoteRepository noteRepository;

    @Test
    void testBuscarNota() {
        Assertions.assertNotNull(noteRepository);
    }
}
