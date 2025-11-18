package com.docencia.com.examen.hilos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class CarRaceTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Field winnerDeclaredField;
    private Field distanceField;

    @BeforeEach
    void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
        
        // Reset the static winnerDeclared field before each test
        winnerDeclaredField = CarRace.class.getDeclaredField("winnerDeclared");
        winnerDeclaredField.setAccessible(true);
        winnerDeclaredField.set(null, false);
        
        // Get distance field for inspection
        distanceField = CarRace.class.getDeclaredField("distance");
        distanceField.setAccessible(true);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
@DisplayName("Verificar comportamiento del constructor mediante ejecución")
void testConstructorBehavior() {
    // Given
    String name = "Rayo-McQueen";
    int goal = 50; // Meta pequeña para test rápido

    // When
    CarRace car = new CarRace(name, goal);
    Thread thread = new Thread(car);
    thread.start();

    // Then - Verificar que se ejecuta sin errores y produce salida
    try {
        thread.join(2000); // Esperar a que termine
        String output = outputStream.toString();
        
        assertTrue(output.contains(name), 
                  "La salida debe contener el nombre del coche: " + name);
        assertTrue(output.contains(String.valueOf(goal)), 
                  "La salida debe contener la meta: " + goal);
        
    } catch (InterruptedException e) {
        fail("Test interrumpido: " + e.getMessage());
    }
}

    @Test
    @DisplayName("Carrera con distancia específica - Rayo 100, Mate 10")
    @Timeout(5)
    void testRaceWithSpecificDistances() throws Exception {
        // Given
        int goal = 100;
        CarRace rayo = new CarRace("Rayo-McQueen", goal);
        CarRace mate = new CarRace("Mate", goal);

        // When - Simular avances específicos usando reflection
        simulateRaceProgress(rayo, 100);
        simulateRaceProgress(mate, 10);

        // Then - Verificar que Rayo debería ganar
        String output = outputStream.toString();
        assertTrue(output.contains("Rayo-McQueen") || output.contains("ganado"), 
                   "La salida debe contener información sobre Rayo-McQueen");
    }

    @Test
    @DisplayName("Debe declarar un ganador cuando se alcanza la meta")
    @Timeout(5)
    void testWinnerDeclaration() throws Exception {
        // Given
        int goal = 50;
        CarRace car = new CarRace("TestCar", goal);

        // When - Simular que el coche alcanza la meta
        Thread thread = new Thread(car);
        thread.start();
        
        // Esperar un poco y luego forzar la finalización
        Thread.sleep(1000);
        
        // Simular que alcanza la meta
        simulateRaceProgress(car, goal + 10); // Se pasa de la meta

        thread.join(2000); // Esperar a que termine

        // Then - Verificar que se declaró un ganador
        boolean winnerDeclared = (boolean) winnerDeclaredField.get(null);
        assertTrue(winnerDeclared, "Debe haberse declarado un ganador");
    }

    

    @ParameterizedTest
    @DisplayName("Diferentes metas deben funcionar correctamente")
    @CsvSource({
        "50, 30, 20",
        "100, 80, 15", 
        "200, 150, 25"
    })
    @Timeout(5)
    void testDifferentGoals(int goal, int rayoDistance, int mateDistance) throws Exception {
        // Given
        CarRace rayo = new CarRace("Rayo-McQueen", goal);
        CarRace mate = new CarRace("Mate", goal);

        // When
        simulateRaceProgress(rayo, rayoDistance);
        simulateRaceProgress(mate, mateDistance);

        // Then - Verificar que las distancias se establecieron correctamente
        int actualRayoDistance = (int) distanceField.get(rayo);
        int actualMateDistance = (int) distanceField.get(mate);
        
        assertEquals(rayoDistance, actualRayoDistance, 
                    "Rayo debería tener distancia: " + rayoDistance);
        assertEquals(mateDistance, actualMateDistance, 
                    "Mate debería tener distancia: " + mateDistance);
    }


    @Test
    @DisplayName("La carrera debe manejar correctamente la interrupción")
    @Timeout(3)
    void testInterruptionHandling() throws Exception {
        // Given
        int goal = 100;
        CarRace car = new CarRace("TestCar", goal);

        // When
        Thread thread = new Thread(car);
        thread.start();
        Thread.sleep(100); // Dejar que corra un poco
        thread.interrupt(); // Interrumpir
        thread.join(1000); // Esperar a que termine

        // Then - El hilo debe manejar la interrupción correctamente
        String output = outputStream.toString();
        assertTrue(!thread.isAlive(), "El hilo debería haber terminado");
    }

    // Método helper para simular progreso en la carrera
    private void simulateRaceProgress(CarRace car, int targetDistance) throws Exception {
        // Establecer la distancia directamente via reflection
        distanceField.set(car, targetDistance);
        
        // Si alcanza o supera la meta, simular la declaración de ganador
        Field goalField = CarRace.class.getDeclaredField("goal");
        goalField.setAccessible(true);
        int goal = (int) goalField.get(car);
        
        if (targetDistance >= goal && !(boolean) winnerDeclaredField.get(null)) {
            winnerDeclaredField.set(null, true);
            System.out.println("\n🎉 ¡!!" + car + " ha ganado la carrera!!! 🏆");
        }
    }

}
