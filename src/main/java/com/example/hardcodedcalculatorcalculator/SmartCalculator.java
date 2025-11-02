package com.example.hardcodedcalculatorcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SmartCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SmartCalculator.class.getResource("calculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 585, 304);
        stage.setTitle("Very Smartly Stupid Calculator");
        stage.setScene(scene);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}