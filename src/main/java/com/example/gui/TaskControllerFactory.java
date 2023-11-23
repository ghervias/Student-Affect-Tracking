package com.example.gui;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

public class TaskControllerFactory {
    public static TaskController createTaskController(Task nextTask){
        try {
            FXMLLoader loader = new FXMLLoader();
            URL location = TaskControllerFactory.class.getResource("/fxml/MathTask.fxml");
            loader.setLocation(location);
            TaskController controller = loader.getController();

            // Set the MyService instance in the controller
            controller.setMyService(nextTask);

            return controller;
        } catch (Exception e) {
            throw new RuntimeException("Error creating controller", e);
        }

    }

}
