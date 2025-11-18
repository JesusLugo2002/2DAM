package com.docencia.com.examen.procesos.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.com.examen.procesos.domain.Job;
import com.docencia.com.examen.procesos.services.impl.DfServiceImpl;


class TopServiceTest {
    String[] allowedCmds;
    DfServiceImpl topServiceImpl;

    @BeforeEach
    void beforeEach() {
        topServiceImpl = new DfServiceImpl();
        allowedCmds = new String[]{"df"};
    }

    
}
