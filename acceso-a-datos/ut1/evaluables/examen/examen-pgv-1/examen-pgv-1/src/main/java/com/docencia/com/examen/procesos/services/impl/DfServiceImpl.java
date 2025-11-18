package com.docencia.com.examen.procesos.services.impl;

import org.springframework.stereotype.Component;

import com.docencia.com.examen.procesos.domain.Job;
import com.docencia.com.examen.procesos.repositories.file.FileJobRepository;
import com.docencia.com.examen.procesos.services.impl.abstracts.CommandServiceAbstract;


@Component
public class DfServiceImpl extends CommandServiceAbstract {

    public DfServiceImpl() {
       setRegex("^(df|DF|Df)\\s+-(h|H|h\\s+\\|\\s+head)$");
       setJob(Job.DF);
       setRepository(new FileJobRepository("logger.txt"));
    }
}
