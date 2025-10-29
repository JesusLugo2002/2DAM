package dam.jesus.process_cli_application.repositories;

import dam.jesus.process_cli_application.repositories.interfaces.JobRepository;

public class FileJobRepository implements JobRepository {

    @Override
    public void writeOutput(String[] lines) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeOutput'");
    }

    @Override
    public void writeError(String[] lines) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeError'");
    }

}
