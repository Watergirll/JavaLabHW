import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputProcessing {
    public static void main(String[] args) {
        String filePath = "temaLab7ex2/input.txt";

        try {
            // a. Cel mai lung cuvânt
            String longestWord = findLongestWord(filePath);
            System.out.println("Cel mai lung cuvânt: " + longestWord);

            // b. Adăugăm conținutul clasei în fișier
            appendClassContentToFile(filePath, "temaLab7ex2/InputProcessing.java");

            // c. Citim fișierul în array
            String[] lines = readFileIntoArray(filePath);
            System.out.println("Conținutul fișierului:");
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }

    // Metoda a
    public static String findLongestWord(String filePath) throws IOException {
        String longestWord = "";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }

    // Metoda b
    public static void appendClassContentToFile(String filePath, String classFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(classFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

            writer.newLine();
            writer.write("=== Conținutul clasei InputProcessing.java ===");
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // Metoda c
    public static String[] readFileIntoArray(String filePath) throws IOException {
        List<String> linesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesList.add(line);
            }
        }
        return linesList.toArray(new String[0]);
    }
}
