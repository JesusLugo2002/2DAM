package dam.jesus.process_cli_application.services.interfaces;

import dam.jesus.process_cli_application.domain.Job;

public interface ICommandService {
    /**
     * Configura el Job tras la validacion y ejecuta el comando.
     * @param line el comando a configurar.
     * @return {@code true} si el comando se configura correctamente, si no, {@code false}
     */
    public boolean setupCommand(String line);

    /**
     * Valida el comando recibido haciendo uso de la expresion regular
     * que establece la estructura correcta.
     * @param line el comando a validar.
     * @return Si la estructura concuerda con la expresion regular, {@code true}, si no, {@code false}.
     */
    public boolean validate(String line);

    /**
     * Ejecuta el {@code Job} configurado del servicio, imprime en pantalla la salida
     * y la guarda en el fichero.
     * @return {@code true} si la ejecucion se ha realizado correctamente, si no, {@code false}.
     */
    public boolean runCommand();

    /**
     * Extrae la salida estandar/de error del {@code job} y las imprime
     * en pantalla junto a sus respectivas etiquetas [OUT]/[ERR].
     * @param job
     */
    public void printOutput(Job job);
}
