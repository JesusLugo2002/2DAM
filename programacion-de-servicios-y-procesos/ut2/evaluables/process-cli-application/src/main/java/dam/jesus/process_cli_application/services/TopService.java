package dam.jesus.process_cli_application.services;

import org.springframework.stereotype.Service;

@Service
public class TopService extends CommandServiceAbstract {
    
    public TopService() {
        setRegex("^top$");
    }

}
