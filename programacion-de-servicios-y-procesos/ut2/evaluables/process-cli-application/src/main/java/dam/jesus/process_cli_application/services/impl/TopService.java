package dam.jesus.process_cli_application.services.impl;

import org.springframework.stereotype.Service;

import dam.jesus.process_cli_application.services.abstracts.CommandServiceAbstract;

/**
 * Clase TopService
 * @author JesusLugo2002
 * Implementacion de CommandService, configurando la expresion regular
 * para su funcionamiento.
 */
@Service
public class TopService extends CommandServiceAbstract {
    
    public TopService() {
        setRegex("^(top)\\s+(-n\\s*1\\s+-b)$");
    }

}
