import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class StudentServiceTest {

    private StudentService studentService;
    private File testInput;
    private File testOutput;

    @BeforeEach
    public void setUp() throws IOException {
        studentService = new StudentService();

        testInput = new File("src/studentsEN.txt");
        testOutput = new File("filtered_students_test_output.txt");

        assertTrue(testInput.exists(), "Input file studentsEN.txt not found in src folder!");
    }

    @Test
    public void testFilterStudentsWithGradeFive() throws IOException {
        studentService.filterStudentsWithGradeFive(testInput.getAbsolutePath(), testOutput.getAbsolutePath());

        List<String> results = Files.readAllLines(testOutput.toPath(), StandardCharsets.UTF_8);

        assertEquals(11, results.size(), "Should find exactly 11 students with grade 5 from the real list.");

        assertTrue(results.stream().anyMatch(line -> line.contains("Jasmeen")), "Jasmeen should be found.");
        assertTrue(results.stream().anyMatch(line -> line.contains("Vaikkath")), "Vaikkath should be found.");

        System.out.println("Test passed! Found " + results.size() + " students with grade 5.");
    }

    @AfterEach
    public void tearDown() {
    }
}