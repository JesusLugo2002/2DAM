package org.formacion.procesos.cli;

import org.springframework.stereotype.Component;

@Component
public class CommandParser {
    
    public String normalize(String commandLine) {
        return commandLine.toLowerCase().trim();
    }

}
