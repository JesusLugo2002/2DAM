package dam.jesus.process_cli_application.services;

import org.springframework.stereotype.Service;

/**
 * Clase LsofService
 * @author JesusLugo2002
 * Implementacion de CommandService, configurando la expresion regular
 * para su funcionamiento.
 */
@Service
public class LsofService extends CommandServiceAbstract {

    public LsofService() {
        setRegex("^(lsof)\\s+(-i)$");
    }

}
