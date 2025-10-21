package org.formacion.procesos.cli;

import java.util.Scanner;

import org.formacion.procesos.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    CommandParser commandParser;

    @Autowired
    JobService jobService;

    @Override
    public void run(String... args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("[OUTPUT] End application!");
        }));

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Lanzador de Procesos (CLI) Linux/Windows ===\n" +
                "Comandos:\n" +
                "  run PING host=8.8.8.8 count=4 timeoutMs=15000\n" +
                "  run LIST_DIR path=.\n" +
                "  run HASH_SHA256 file=README.md\n" +
                "  help | os | exit\n");

        String line;
        do {
            line = scanner.nextLine();
            line = commandParser.normalize(line);
            if (line.startsWith("run")) {
                jobService.init(line.substring(4));
            }
        } while (!line.equals("exit"));

        scanner.close();
    }

}
