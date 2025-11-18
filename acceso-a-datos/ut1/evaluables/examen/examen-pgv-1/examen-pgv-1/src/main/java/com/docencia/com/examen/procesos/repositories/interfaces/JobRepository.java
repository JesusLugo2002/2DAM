package com.docencia.com.examen.procesos.repositories.interfaces;

import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository {
    boolean add(String content);
}
