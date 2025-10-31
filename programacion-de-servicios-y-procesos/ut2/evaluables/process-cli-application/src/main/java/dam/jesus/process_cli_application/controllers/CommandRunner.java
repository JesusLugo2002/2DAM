package dam.jesus.process_cli_application.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dam.jesus.process_cli_application.services.impl.LsofService;
import dam.jesus.process_cli_application.services.impl.PsService;
import dam.jesus.process_cli_application.services.impl.TopService;

/**
 * Clase CommandRunner
 * @author JesusLugo2002
 * Se encarga de activar el servicio necesario para ejecutar el comando recibido.
 */
@Controller
public class CommandRunner {

    private static Logger logger = LoggerFactory.getLogger(CommandRunner.class);

    LsofService lsofService;
    TopService topService;
    PsService psService;
    
    @Autowired
    public void setLsofService(LsofService lsofService) {
        this.lsofService = lsofService;
    }

    @Autowired
    public void setTopService(TopService topService) {
        this.topService = topService;
    }

    @Autowired
    public void setPsService(PsService psService) {
        this.psService = psService;
    }

    /**
     * Activa el servicio necesario segun el comando recibido.
     * @param line el comando recibido.
     * @return si el comando puede ser ejecutado, devuelve {@code true},
     * si no, {@code false}.
     */
    public boolean handle(String line) {
        if (line == null || line.isBlank()) {
            logger.error("Empty command.");
            return false;
        }
        String command = line.split("\\s+")[0];
        switch (command) {
            case "lsof" -> lsofService.setupCommand(line);
            case "top" -> topService.setupCommand(line);
            case "ps" -> psService.setupCommand(line);
            default -> logger.info("Undefined command.");
        }
        return true;
    }
}
