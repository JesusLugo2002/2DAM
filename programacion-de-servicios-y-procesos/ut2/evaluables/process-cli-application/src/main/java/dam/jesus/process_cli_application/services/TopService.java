package dam.jesus.process_cli_application.services;

import org.springframework.stereotype.Service;

import dam.jesus.process_cli_application.domain.Job;

@Service
public class TopService extends CommandServiceAbstract {
    
    public TopService() {
        setRegex("^top$");
    }

    @Override
    public Job handleCommand() {
        System.out.println(getJob());
        System.out.println("Ejecutando TOP");
        return getJob();
    }

}
