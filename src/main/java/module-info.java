module com.example.logbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.logbook to javafx.fxml;
    exports com.example.logbook;
}