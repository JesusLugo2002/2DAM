package dam.tareas.jesus.proc_cli_application.controllers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class CliController implements CommandLineRunner {

    @Autowired
    CommandRunner commandRunner;

    private String normalize(String line) {
        return line.trim().toLowerCase();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Lanzador de Procesos (CLI) Linux ===\n" + //
                        "Comandos:\n" + //
                        "  lsof -i\n" + //
                        "  top\n" + //
                        "  ps aux | head\n ");
        Scanner scanner = new Scanner(System.in);
        String line = normalize(scanner.nextLine());
        commandRunner.handle(line);
        scanner.close();
    }

}
