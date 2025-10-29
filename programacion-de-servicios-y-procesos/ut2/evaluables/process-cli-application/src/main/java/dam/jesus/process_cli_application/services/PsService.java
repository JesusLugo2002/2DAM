package dam.jesus.process_cli_application.services;

import org.springframework.stereotype.Service;

@Service
public class PsService extends CommandServiceAbstract {
    
    public PsService() {
        setRegex("^(ps)\\s+(aux\\s+\\|\\s+head)$");
    }

}
