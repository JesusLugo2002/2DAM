package dam.jesus.spring_cli.cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Cierra la aplicación");
        }));

        System.out.println("=== Lanzador de Procesos (CLI) Linux/Windows ===");

        while (true) {
            
        }
    } 

}
