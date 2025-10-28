package dam.tareas.jesus.proc_cli_application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dam.tareas.jesus.proc_cli_application.services.LsofJobService;

@Controller
public class CommandRunner {

    @Autowired
    LsofJobService lsofJobService;

    public void handle(String normalizedLine) {

        if (normalizedLine.startsWith("ps")) {
            
        } else if (normalizedLine.startsWith("top")) {

        } else if (normalizedLine.startsWith("lsof")) {
            lsofJobService.handleCommand(normalizedLine);
        } else {
            System.out.println("[ERROR] Invalid command.");
        }
    }

}
