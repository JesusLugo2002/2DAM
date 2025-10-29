package dam.jesus.process_cli_application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dam.jesus.process_cli_application.services.LsofService;
import dam.jesus.process_cli_application.services.PsService;
import dam.jesus.process_cli_application.services.TopService;

@Controller
public class CommandRunner {

    @Autowired
    LsofService lsofService;

    @Autowired
    TopService topService;

    @Autowired
    PsService psService;

    public void handle(String line) {
        if (line == null || line.isBlank()) {
            System.out.println("[ERROR] Empty command!");
            return;
        }
        String command = line.split("\\s+")[0];
        switch (command) {
            case "lsof" -> lsofService.setupCommand(line);
            case "top" -> topService.setupCommand(line);
            case "ps" -> psService.setupCommand(line);
            default -> System.out.println("[ERROR] Invalid command!");
        }
    }
}
