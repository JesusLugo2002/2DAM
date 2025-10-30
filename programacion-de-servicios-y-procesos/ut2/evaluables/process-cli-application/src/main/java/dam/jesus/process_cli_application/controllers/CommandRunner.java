package dam.jesus.process_cli_application.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dam.jesus.process_cli_application.services.LsofService;
import dam.jesus.process_cli_application.services.PsService;
import dam.jesus.process_cli_application.services.TopService;

/**
 * Clase CommandRunner
 * @author JesusLugo2002
 * Se encarga de activar el servicio necesario para ejecutar el comando recibido.
 */
@Controller
public class CommandRunner {

    private static Logger logger = LoggerFactory.getLogger(CommandRunner.class);

    @Autowired
    LsofService lsofService;

    @Autowired
    TopService topService;

    @Autowired
    PsService psService;

    /**
     * Activa el servicio necesario segun el comando recibido.
     * @param line el comando recibido.
     */
    public void handle(String line) {
        if (line == null || line.isBlank()) {
            logger.error("Empty command.");
            return;
        }
        String command = line.split("\\s+")[0];
        switch (command) {
            case "lsof" -> lsofService.setupCommand(line);
            case "top" -> topService.setupCommand(line);
            case "ps" -> psService.setupCommand(line);
            default -> logger.info("Undefined command.");
        }
    }
}
