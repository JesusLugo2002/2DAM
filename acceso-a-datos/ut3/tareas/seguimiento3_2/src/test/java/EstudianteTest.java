import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.jesus.Estudiante;
import org.jesus.EstudianteMejorado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstudianteTest {

    ByteArrayOutputStream outContent;
    List<String> names;

    @BeforeEach
    void beforeEach() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        names = Arrays.asList("Jesus", "Rashi", "Joseph", "German", "Cesar", "David");
    }

    @Test
    void testEstudiante() {
        Estudiante estudiante = new Estudiante();
        estudiante.main(null);

        String output = outContent.toString();
        names.forEach((name) -> Assertions.assertTrue(output.contains(name)));
    }

    @Test
    void testEstudianteMejorado() {
        EstudianteMejorado estudiante = new EstudianteMejorado();
        estudiante.main(null);
        
        String output = outContent.toString();
        names.forEach((name) -> Assertions.assertTrue(output.contains(name)));
        List<String> equipmentNumbers = Arrays.asList("1", "2", "3", "4");
        equipmentNumbers.forEach((num) -> Assertions.assertTrue(output.contains(num)));
    }

}
