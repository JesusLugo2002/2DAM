package org.formacion.procesos.controller.abstracts;

import java.util.List;

public abstract class CommandControllerAbstract {
    String command;
    List<String> arguments;

    public void setCommand(String command) {
        this.command = command;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public String getCommand() {
        return command;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void processLine(String line) {
        String[] commandSegments = line.split(" ");
        this.command = commandSegments[0];
        
        if (!command.equals("ps")) {
            System.out.println("El comando es inválido");
        }
    }
}
