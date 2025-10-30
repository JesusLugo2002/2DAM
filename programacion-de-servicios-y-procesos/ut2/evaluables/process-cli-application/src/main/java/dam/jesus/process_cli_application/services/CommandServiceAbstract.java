package dam.jesus.process_cli_application.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dam.jesus.process_cli_application.domain.Job;
import dam.jesus.process_cli_application.repositories.FileJobRepository;
import dam.jesus.process_cli_application.services.interfaces.ICommandService;

/**
 * Clase CommandServiceAbstract
 * @author JesusLugo2002
 * Se encarga de la configuracion, validacion y ejecucion del comando en el servicio,
 * asi como tambien de imprimir la salida del proceso en la terminal.
 */
public abstract class CommandServiceAbstract implements ICommandService {

    FileJobRepository fileJobRepository;

    @Autowired
    public void setFileJobRepository(FileJobRepository fileJobRepository) {
        this.fileJobRepository = fileJobRepository;
    }

    private static Logger logger = LoggerFactory.getLogger(CommandServiceAbstract.class);

    private Job job;
    private String regex;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getRegex() {
        return regex;
    }
    
    public void setRegex(String regex) {
        this.regex = regex;
    }

    public boolean setupCommand(String line) {
        if (!validate(line)) {
            logger.warn("Invalid command or parameters!");
            return false;
        }
        Job job = new Job(line);
        this.setJob(job);
        this.runCommand();
        return true;
    }

    /**
     * @returns Si la estructura concuerda con la expresion regular, {@code true}, si no, {@code false}.
     */
    public boolean validate(String line) {
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    /**
     * @returns {@code true} si la ejecucion se ha realizado correctamente, si no, {@code false}.
     */
    public boolean runCommand() {
        Job job = getJob();
        Process process = job.execute();
        if (process == null) {
            logger.error("Job process is null!");
            return false;
        }
        fileJobRepository.writeFile(job);
        printOutput(job);
        return true;
    }

    public void printOutput(Job job) {
        job.getOutLines().forEach(line -> System.out.println(line));
        job.getErrLines().forEach(line -> System.out.println(line));
    }
}
