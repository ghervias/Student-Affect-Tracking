module com.example.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
    exports tasks;
    opens tasks to javafx.fxml;
}