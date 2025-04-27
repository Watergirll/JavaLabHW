import java.io.*;
import java.util.Scanner;

public class MyCalculator implements Calculator {

    @Override
    public double add(Double a, Double b) throws NullParameterException, OverflowException, UnderflowException {
        if (a == null || b == null) {
            throw new NullParameterException("Unul dintre parametrii este null!");
        }
        double sum = a + b;
        if (sum == Double.POSITIVE_INFINITY) {
            throw new OverflowException("Overflow: suma este infinită pozitivă!");
        }
        if (sum == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException("Underflow: suma este infinită negativă!");
        }
        return sum;
    }

    @Override
    public double divide(Double a, Double b) throws NullParameterException, MyArithmeticException {
        if (a == null || b == null) {
            throw new NullParameterException("Unul dintre parametrii este null!");
        }
        if (b == 0) {
            throw new MyArithmeticException("Împărțire la zero!");
        }
        return a / b;
    }

    @Override
    public double average(Double[] numbers) throws NullParameterException, OverflowException, UnderflowException, MyArithmeticException {
        if (numbers == null) {
            throw new NullParameterException("Vectorul este null!");
        }

        MyCalculator calc = new MyCalculator();
        double sum = 0.0;
        for (Double num : numbers) {
            sum = calc.add(sum, num);
        }
        return calc.divide(sum, (double) numbers.length);
    }

    public Double[] readNumbersFromFile(String filePath) throws IOException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            Double[] numbers = new Double[100];  // presupunem maxim 100 numere
            int index = 0;
            while (scanner.hasNextDouble()) {
                numbers[index++] = scanner.nextDouble();
            }
            Double[] result = new Double[index];
            System.arraycopy(numbers, 0, result, 0, index);
            return result;
        } catch (FileNotFoundException e) {
            throw new IOException("Fișierul nu a fost găsit: " + filePath);
        }
    }
}
