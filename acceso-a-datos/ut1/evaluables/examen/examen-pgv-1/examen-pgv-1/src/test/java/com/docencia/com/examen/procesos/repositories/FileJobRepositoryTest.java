package com.docencia.com.examen.procesos.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.docencia.com.examen.procesos.repositories.file.FileJobRepository;


class FileJobRepositoryTest {
    @Test
    void invalidFilePathTest() {
        FileJobRepository jobRepository = new FileJobRepository("loooooooooooger.txt");
        Assertions.assertFalse(jobRepository.add("HolA"));
    }

    
}
