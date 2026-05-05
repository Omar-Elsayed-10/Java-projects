import java.io.*;
import java.nio.charset.StandardCharsets;

public class StudentService {

    public void filterStudentsWithGradeFive(String inputPath, String outputPath) throws IOException {
        String regex = ".*5.*";

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_16));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(outputPath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(regex)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }
}