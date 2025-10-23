package org.formacion.procesosservicios.repositories;

import org.formacion.procesos.repositories.FileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileRepositoryTest {

    static FileRepository fileRepository;

    @BeforeEach
    static void beforeAll() {
        fileRepository = new FileRepository();
    }

    @Test
    void addContentTest() {
        boolean result = fileRepository.add("Texto");
        Assertions.assertTrue(result);
    }

}
