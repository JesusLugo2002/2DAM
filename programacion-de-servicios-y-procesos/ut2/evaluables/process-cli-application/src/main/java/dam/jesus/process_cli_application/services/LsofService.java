package dam.jesus.process_cli_application.services;

import org.springframework.stereotype.Service;

import dam.jesus.process_cli_application.domain.Job;

@Service
public class LsofService extends CommandServiceAbstract {

    public LsofService() {
        setRegex("^(lsof)\\s+(-i)$");
    }

    @Override
    public Job handleCommand() {
        System.out.println(getJob());
        System.out.println("Ejecutando LSOF");
        return getJob();
    }

}
