# Procesos-servicios

Proyecto Maven con **Spring Boot** (JDK 17). Demuestra cómo **ejecutar y controlar procesos externos en Linux** desde Java mediante `ProcessBuilder`.

## 🚀 Requisitos

- JDK 17 instalado y configurado (`java -version`).
- Maven 3.9+ (`mvn -version`).
- Linux (se usan comandos como `ls`, `ps`, `sort`, `sleep`).

## ▶️ Cómo ejecutar

1. Clonar o descargar este proyecto.
2. En la raíz del proyecto, compilar:

   ```bash
   mvn clean package
   ```

3. Ejecutar la aplicación directamente con Spring Boot:

   ```bash
   mvn spring-boot:run
   ```

   o bien usar el JAR generado:

   ```bash
   java -jar target/procesos-servicios-0.0.1-SNAPSHOT.jar
   ```

## 📂 Estructura
  
**ProcesosServiciosApplication** 

- → clase principal de Spring Boot.
- **Procesos** → componente que implementa ejemplos de uso de procesos:
  - `listarDirectorio(String ruta)` → ejecuta `ls -l`.
  - `contarProcesosJava()` → ejecuta `ps aux | grep java | wc -l`.
  - `guardarProcesosAFichero(Path destino)` → guarda procesos en un fichero.
  - `ordenarTextoConSort(String[] lineas)` → ordena texto con `sort`.
  - `ejecutarConTimeout(String[] comando, long timeoutMs)` → ejecuta con límite de tiempo.
  - `ejecutarEnParalelo(List<List<String>> comandos, int maxParalelos)` → varios procesos simultáneos.

## 💡 Notas

- Para Windows deberás adaptar los comandos (`cmd /c`).
- El proyecto ejecuta una **demo automática** al arrancar (CommandLineRunner).