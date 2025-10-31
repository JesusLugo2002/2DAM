package dam.jesus.process_cli_application.controllers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

/**
 * Clase CliController
 * @author JesusLugo2002
 * Se encarga de recibir el comando por parte del usuario y enviarlo al CommandRunner.
 */
@Controller
public class CliController implements CommandLineRunner {

    @Autowired
    CommandRunner commandRunner;

    /**
     * Inicia el programa mostrando en pantalla las opciones posibles
     * y recibiendo por parte del usuario el comando para enviarlo
     * al CommandRunner.
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Lanzador de Procesos (CLI) Linux ===\r\n" + //
                        "Comandos:\r\n" + //
                        "  lsof -i\r\n" + //
                        "  top -n1 -b\r\n" + //
                        "  ps aux | head\n");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim().toLowerCase();
        scanner.close();
        commandRunner.handle(line);
    }
}
