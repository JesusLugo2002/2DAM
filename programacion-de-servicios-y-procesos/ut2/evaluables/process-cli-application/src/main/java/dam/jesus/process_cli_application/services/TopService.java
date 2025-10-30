package dam.jesus.process_cli_application.services;

import org.springframework.stereotype.Service;

/**
 * Clase TopService
 * @author JesusLugo2002
 * Implementacion de CommandService, configurando la expresion regular
 * para su funcionamiento.
 */
@Service
public class TopService extends CommandServiceAbstract {
    
    public TopService() {
        setRegex("^top$");
    }

}
