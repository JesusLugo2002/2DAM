package org.formacion.procesos.controller;

import org.formacion.procesos.controller.abstracts.CommandControllerAbstract;
import org.springframework.stereotype.Component;

@Component
public class CommandControllerPs extends CommandControllerAbstract {
    
    public void processLine(String line) {
        String[] commandSegments = line.split(" ");
        setCommand(commandSegments[0]);
        
        if (!getCommand().equals("ps")) {
            System.out.println("El comando es inválido");
        }

        Process process;
        try {
            process = new ProcessBuilder("sh", "-c", line + "> mis_procesos.txt")
            .start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
