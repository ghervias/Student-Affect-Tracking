module gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.json;
    requires Java.WebSocket;


    opens gui to javafx.fxml;
    exports gui;
    exports tasks;
    opens tasks to javafx.fxml;
    exports gui.controllers;
    opens gui.controllers to javafx.fxml;
    exports emotiv;
    exports data;
}