package dam.jesus.process_cli_application.services;

import org.springframework.stereotype.Service;

@Service
public class LsofService extends CommandServiceAbstract {

    public LsofService() {
        setRegex("^(lsof)\\s+(-i)$");
    }

}
