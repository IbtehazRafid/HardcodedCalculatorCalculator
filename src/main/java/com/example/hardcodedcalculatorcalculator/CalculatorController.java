package com.example.hardcodedcalculatorcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CalculatorController {
    @FXML private TextField inputField;
    @FXML private Button bSeven;
    @FXML private Button bEight;
    @FXML private Button bNine;
    @FXML private Button bFour;
    @FXML private Button bFive;
    @FXML private Button bSix;
    @FXML private Button bZero;
    @FXML private Button bOne;
    @FXML private Button bTwo;
    @FXML private Button bThree;
    @FXML private Button divide;
    @FXML private Button multiply;
    @FXML private Button subtract;
    @FXML private Button add;
    @FXML private Button decimal;
    @FXML private Button equals;
    @FXML private Button clearAll;
    @FXML private Button history;
    @FXML private Button clear;
    private static String num1 = "";
    private static String num2 = "";
    private static String operation = "";
    private boolean equalPressed;
    CalcMain calc = new CalcMain();

    @FXML
    private void handleButtonClick(ActionEvent e) throws IOException, InterruptedException {
        String button = ((Button) e.getSource()).getText();
        if (button.equals("1") || button.equals("2") || button.equals("3") || button.equals("4") || button.equals("5") || button.equals("6") || button.equals("7") || button.equals("8") || button.equals("9") || button.equals("0") || button.equals(".")) {
            if (equalPressed) {
                inputField.clear();
                equalPressed = false;
            }
            inputField.appendText(button);
        } else if (button.equals("/") || button.equals("*") || button.equals("-") || button.equals("+")) {
            if (equalPressed) {
                equalPressed = false;
            }
            num1 = inputField.getText();
            operation = button;
            inputField.clear();

        } else if (button.equals("=")) {
            equalPressed = true;
            num2 = inputField.getText();
            if (operation.isEmpty()) {
                operation = "NO OPERATION";
            }
            if (num1.isEmpty()) {
                if (num2.isEmpty()) {
                    inputField.setText("0.0");
                } else {
                    inputField.setText(num2);
                }
            } else if (num2.isEmpty()) {
                inputField.setText(num1);
            } else {
                calc.calculate(Double.parseDouble(num1), Double.parseDouble(num2), operation);
                String res = "";
                try (Scanner scanner = new Scanner(new File("src/main/java/com/example/hardcodedcalculatorcalculator/result.txt"))) {
                    while (scanner.hasNextLine()) {
                        res = scanner.nextLine();
                    }
                } catch (FileNotFoundException a) {
                    System.err.println("File not found: " + a.getMessage());
                    a.printStackTrace();
                }
                inputField.setText(res);
            }

        } else if (button.equals("AC")) {
            inputField.clear();
            num1 = "";
            num2 = "";
            operation = "";

        } else if (button.equals("Clear")) {
            inputField.setText("");
        }
    }
}