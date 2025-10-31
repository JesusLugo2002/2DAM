package dam.jesus.process_cli_application.repositories.interfaces;

import java.nio.file.Path;

import dam.jesus.process_cli_application.domain.Job;

public interface JobRepository {
    /**
     * Crea el archivo en el {@code filepath} determinado.
     * @param filepath ruta donde se creara el archivo.
     * @return {@code true} si se ha creado el archivo, si no, {@code false}.
     */
    public boolean createFile(Path filepath);

    /**
     * Comprueba que el fichero exista en el {@code filepath} determinado.
     * @param filepath ruta que se comprobara.
     * @return {@code true} si el archivo existe, si no, {@code false}.
     */
    public boolean exists(Path filepath);

    /**
     * Escribe en el archivo la salida de {@code job}. Si en el proceso,
     * al comprobar que el archivo existe, determina que no, se crea el archivo.
     * Luego escribe primero la salida estandar y luego la de error.
     * @param job
     * @return {@code true} si pudo escribirse el archivo correctamente, si no, {@code false}.
     */
    public boolean writeFile(Job job);
}
