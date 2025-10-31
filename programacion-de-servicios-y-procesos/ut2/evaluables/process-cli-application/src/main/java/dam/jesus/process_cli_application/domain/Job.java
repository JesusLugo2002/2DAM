package dam.jesus.process_cli_application.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Job
 * @author JesusLugo2002
 * Representa un proceso y contiene los metodos para mostrar y cargar el
 * output de su ejecucion. 
 */
public class Job {

    private static Logger logger = LoggerFactory.getLogger(Job.class);

    private String id;
    private String command;
    private Process process;
    private List<String> outLines;
    private List<String> errLines;

    public List<String> getOutLines() {
        return outLines;
    }

    public void setOutLines(List<String> outLines) {
        this.outLines = outLines;
    }

    public List<String> getErrLines() {
        return errLines;
    }

    public void setErrLines(List<String> errLines) {
        this.errLines = errLines;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Job(String command) {
        setCommand(command);
        setId(command.split("\\s+")[0] + "-" + LocalTime.now());
    }
    
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * Ejecuta el proceso construyendo un ProcessBuilder con el comando actual.
     * El proceso ejecutado es guardado y se almacena como variables la salida estandar
     * y la salida de error.
     * @return Proceso ejecutado o {@code null} si hubo un error.
     */
    public Process execute() {
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", this.getCommand());
        processBuilder.redirectErrorStream(false);
        try {
            Process process = processBuilder.start();
            setProcess(process);
            saveStdout(process);
            saveStderr(process);
            return process;
        } catch (Exception e) {
            logger.error("An error happens executing the process", e);
        }
        return null;
    }

    /**
     * Guarda la salida estandar como variable de la instancia como lista,
     * aplicando el prefijo [OUT].
     * @param process proceso del que se extraera la salida.
     */
    private void saveStdout(Process process) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            setOutLines(reader.lines().map(line -> "[OUT] " + line).toList());
        } catch (Exception e) {
            logger.error("Error saving stdout from process {}", process, e);
        }
    }

    /**
     * Guarda la salida de error como variable de la instancia como lista,
     * aplicando el prefijo [ERR].
     * @param process proceso del que se extraera la salida.
     */
    private void saveStderr(Process process) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            setErrLines(reader.lines().map(line -> "[ERR] " + line).toList());
        } catch (Exception e) {
            logger.error("Error saving stdout from process {}", process, e);
        }
    }
}
