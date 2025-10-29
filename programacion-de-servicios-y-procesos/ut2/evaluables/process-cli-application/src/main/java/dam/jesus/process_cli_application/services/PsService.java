package dam.jesus.process_cli_application.services;

import org.springframework.stereotype.Service;

import dam.jesus.process_cli_application.domain.Job;

@Service
public class PsService extends CommandServiceAbstract {
    
    public PsService() {
        setRegex("^(ps)\\s+(aux\\s+|\\s+head)$");
    }

    @Override
    public Job handleCommand() {
        System.out.println(getJob());
        System.out.println("Ejecutando PS");
        return getJob();
    }

}
