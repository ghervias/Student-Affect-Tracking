package gui;

import gui.controllers.TaskController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tasks.Session;

public class Main extends Application {
    private Stage primaryStage;
    Session session;

    public static void main(String[] args) {
        launch(args);
        System.out.println("here");
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        //session setup. eventually, this will happen on a separate page.

        try {
            //load the fxml and set it as the "root" view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/SessionSetup.fxml"));
            Parent root = loader.load();

            //old code that goes straight to first task
//            //get the controller for the view and set its task to be the next task.
//            Controller controller = loader.getController();
//            controller.setMyService(session);
//
            //display the view
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToNewScene() {
        try {
            //load the fxml and set it as the "root" view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/MathTask.fxml"));
            Parent root = loader.load();

            //get the controller for the view and set its task to be the next task.
            TaskController controller = loader.getController();
            controller.setMyService(session);

            //display the view
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

}


//goals for this work session:
//implement a "task" scene .fxml file using Scene Builder
