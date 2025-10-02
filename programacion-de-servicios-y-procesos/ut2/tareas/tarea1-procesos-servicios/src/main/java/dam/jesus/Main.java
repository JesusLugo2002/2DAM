package dam.jesus;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", "ps aux | grep java");
        processBuilder.redirectErrorStream(true);
        processBuilder.redirectOutput(new File("mis_procesos.txt"));
        Process process = processBuilder.start();
        if (process.waitFor() == 0) {
            processBuilder.command("wc", "-l", "mis_procesos.txt");
            processBuilder.redirectOutput(Redirect.PIPE);
            Process otherProcess = processBuilder.start();
            try (var br = new BufferedReader(new InputStreamReader(otherProcess.getInputStream()))) {
                Integer lines = Integer.parseInt(br.readLine().split(" ")[0]);
                System.out.println("El fichero tiene " + String.valueOf(lines) + " líneas");
                if (lines > 3) {
                    System.out.println("¡Cuidado, muchos procesos de Java activos!");
                }
            }
        }  
    }
}