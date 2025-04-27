import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();

        try {
            // Test add cu null
            calculator.add(null, 5.0);
        } catch (Exception e) {
            System.out.println("Add cu null: " + e.getMessage());
        }

        try {
            // Test add cu overflow
            calculator.add(Double.MAX_VALUE, Double.MAX_VALUE);
        } catch (Exception e) {
            System.out.println("Add cu overflow: " + e.getMessage());
        }

        try {
            // Test divide la zero
            calculator.divide(5.0, 0.0);
        } catch (Exception e) {
            System.out.println("Divide la zero: " + e.getMessage());
        }

        try {
            // Test average
            Double[] numbers = calculator.readNumbersFromFile("temaLab7ex1/input.txt");
            double avg = calculator.average(numbers);
            System.out.println("Average calculat: " + avg);
        } catch (IOException e) {
            System.out.println("Eroare la citire fișier: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Altă eroare: " + e.getMessage());
        }
    }
}
