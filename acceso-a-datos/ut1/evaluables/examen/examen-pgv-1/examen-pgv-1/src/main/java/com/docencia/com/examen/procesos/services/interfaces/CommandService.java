package com.docencia.com.examen.procesos.services.interfaces;

public interface CommandService {
    boolean processLine(String command, boolean changeCmd);
}
