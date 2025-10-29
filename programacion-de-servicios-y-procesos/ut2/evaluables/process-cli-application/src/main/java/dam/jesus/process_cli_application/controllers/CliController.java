package dam.jesus.process_cli_application.controllers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class CliController implements CommandLineRunner {

    @Autowired
    CommandRunner commandRunner;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Lanzador de Procesos (CLI) Linux ===\r\n" + //
                        "Comandos:\r\n" + //
                        "  lsof -i\r\n" + //
                        "  top\r\n" + //
                        "  ps aux | head\n");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim().toLowerCase();
        commandRunner.handle(line);
        scanner.close();
    }
}
