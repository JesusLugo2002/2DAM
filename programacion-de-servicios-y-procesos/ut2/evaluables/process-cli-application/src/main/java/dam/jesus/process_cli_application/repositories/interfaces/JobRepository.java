package dam.jesus.process_cli_application.repositories.interfaces;

import java.nio.file.Path;

import dam.jesus.process_cli_application.domain.Job;

public interface JobRepository {
    /**
     * Crea el archivo en el {@code filepath} determinado.
     * @param filepath ruta donde se creara el archivo.
     */
    public boolean createFile(Path filepath);

    /**
     * Comprueba que el fichero exista en el {@code filepath} determinado.
     * @param filepath ruta que se comprobara.
     */
    public boolean exists(Path filepath);

    /**
     * Escribe en el archivo la salida de {@code job}
     * @param job
     */
    public void writeFile(Job job);
}
