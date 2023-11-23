package com.example.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
        System.out.println("here");
    }
    @Override
    public void start(Stage stage) throws Exception {

        Task task;
        ArrayList<Task> listOfTasks;
        Session session;
        task = new DefaultTask("1 + 1", "2");
        listOfTasks = new ArrayList<>();
        listOfTasks.add(task);
        session = new Session(10, listOfTasks);


        try {



            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/MathTask.fxml"));
            Parent root = loader.load();



//            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CodingTask.fxml"));
            TaskController controller = loader.getController();
            controller.setMyService(session.nextTask());

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            controller.updateDynamicText();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


//goals for this work session:
//implement a "task" scene .fxml file using Scene Builder
