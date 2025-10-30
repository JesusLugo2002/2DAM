package dam.jesus.process_cli_application.services.interfaces;

import dam.jesus.process_cli_application.domain.Job;

public interface ICommandService {
    /**
     * Configura el Job tras la validacion y ejecuta el comando.
     * @param line el comando a configurar.
     * @return true/false si ejecuta correctamente
     */
    public boolean setupCommand(String line);

    /**
     * Valida el comando recibido haciendo uso de la expresion regular
     * que establece la estructura correcta.
     * @param line el comando a validar.
     */
    public boolean validate(String line);

    /**
     * Ejecuta el {@code Job} configurado del servicio, imprime en pantalla la salida
     * y la guarda en el fichero.
     */
    public boolean runCommand();

    /**
     * Extrae la salida estandar/de error del {@code job} y las imprime
     * en pantalla junto a sus respectivas etiquetas [OUT]/[ERR].
     * @param job
     */
    public void printOutput(Job job);
}
