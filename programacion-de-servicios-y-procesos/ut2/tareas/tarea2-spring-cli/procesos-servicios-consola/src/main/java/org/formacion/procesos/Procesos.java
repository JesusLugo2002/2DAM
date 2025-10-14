package org.formacion.procesos;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

@Component
public class Procesos {

    public void ejecutar() {
        try {
            System.out.println("Ejecutando lógica del proceso...");

            Process proceso1 = new ProcessBuilder("sh", "-c", "ps aux | grep java > mis_procesos.txt")
                    .start();
            proceso1.waitFor();

            Process proceso2 = new ProcessBuilder("sh", "-c", "wc -l mis_procesos.txt")
                    .redirectErrorStream(true)
                    .start();

            int numeroLineas = 0;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso2.getInputStream()))) {
                String out = br.readLine(); 
                if (out != null && !out.isBlank()) {
                    numeroLineas = Integer.parseInt(out.trim().split("\\s+")[0]);
                }
            }
            proceso2.waitFor();

            System.out.println("Lineas en mis_procesos.txt: " + numeroLineas);

            if (numeroLineas > 3) {
                System.out.println("¡Cuidado, muchos procesos de Java activos!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
