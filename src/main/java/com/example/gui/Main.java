package com.example.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CodingTask.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


//goals for this work session:
//implement a "task" scene .fxml file using Scene Builder
