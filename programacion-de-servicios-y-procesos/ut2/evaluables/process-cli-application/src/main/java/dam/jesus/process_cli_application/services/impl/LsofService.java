package dam.jesus.process_cli_application.services.impl;

import org.springframework.stereotype.Service;

import dam.jesus.process_cli_application.services.abstracts.CommandServiceAbstract;

/**
 * Clase LsofService
 * @author JesusLugo2002
 * Implementacion de CommandService, configurando la expresion regular
 * para su funcionamiento.
 */
@Service
public class LsofService extends CommandServiceAbstract {

    public LsofService() {
        setRegex("^(lsof)(?:\\s+(-i))?$");
    }

}
