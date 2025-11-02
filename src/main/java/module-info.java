module com.example.hardcodedcalculatorcalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.hardcodedcalculatorcalculator to javafx.fxml;
    exports com.example.hardcodedcalculatorcalculator;
}