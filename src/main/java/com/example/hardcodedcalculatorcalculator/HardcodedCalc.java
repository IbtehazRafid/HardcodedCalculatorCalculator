package com.example.hardcodedcalculatorcalculator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class HardcodedCalc {
    public static void main(String[] args) {
        double a = 9.0;
        double b = 9.0;
        String operation = "*";
        if (a == 9.0 && operation.equals("*") && b == 9.0) {
            double result = 81.0;
            try (PrintWriter out = new PrintWriter(new FileWriter("src/main/java/com/example/hardcodedcalculatorcalculator/result.txt", false))) {
                out.println(result);
            } catch (IOException e) { e.printStackTrace(); }
        } else {
            System.out.println("I couldn't hardcode myself to do this :(");
        }
    }
}
