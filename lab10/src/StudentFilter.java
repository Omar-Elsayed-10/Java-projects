import java.io.*;
import java.nio.charset.StandardCharsets;

public class StudentFilter {
    public static void main(String[] args) {
        // Since your file is in 'src', we include that in the path
        // Alternatively, move the file to the project root and use "studentsEN.txt"
        String inputFileName = "src/studentsEN.txt";
        String outputFileName = "students_grade_5.txt";

        System.out.println("Starting process...");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFileName), StandardCharsets.UTF_16));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(outputFileName), StandardCharsets.UTF_8))) {

            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                // We trim the line to remove hidden spaces and check if it ends with "5"
                if (line.trim().endsWith("5")) {
                    writer.write(line);
                    writer.newLine();
                    count++;
                }
            }

            System.out.println("Success! Found " + count + " students with grade 5.");
            System.out.println("Results saved to: " + new File(outputFileName).getAbsolutePath());

        } catch (FileNotFoundException e) {
            System.err.println("Error: The file '" + inputFileName + "' was not found. " +
                    "Make sure it is inside the 'src' folder.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading/writing: " + e.getMessage());
        }
    }
}