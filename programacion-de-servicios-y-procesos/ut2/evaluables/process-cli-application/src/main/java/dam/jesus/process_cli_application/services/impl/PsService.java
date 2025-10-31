package dam.jesus.process_cli_application.services.impl;

import org.springframework.stereotype.Service;

import dam.jesus.process_cli_application.services.abstracts.CommandServiceAbstract;

/**
 * Clase PsService
 * @author JesusLugo2002
 * Implementacion de CommandService, configurando la expresion regular
 * para su funcionamiento.
 */
@Service
public class PsService extends CommandServiceAbstract {
    
    public PsService() {
        setRegex("^(ps)\\s+(aux\\s+\\|\\s+head)$");
    }

}
