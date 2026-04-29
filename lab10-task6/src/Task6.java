import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URI; 
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first 3 digits of the bank account: ");
        String searchPrefix = scanner.nextLine().trim();

        if (searchPrefix.length() != 3) {
            System.out.println("Error: Please enter exactly 3 digits.");
            return;
        }

        String fileUrl = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

        try {
            URL url = URI.create(fileUrl).toURL();

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            String line;
            boolean found = false;

            System.out.println("Searching database...");
            System.out.println("-----------------------------------");

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(searchPrefix)) {
                    String[] parts = line.split("\\t+");
                    if (parts.length >= 2) {
                        String bankNumber = parts[0].trim();
                        String bankName = parts[1].trim();

                        System.out.println("Abbreviated Bank Number: " + bankNumber);
                        System.out.println("Name of the Bank: " + bankName);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("No bank found with the prefix: " + searchPrefix);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading data: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
