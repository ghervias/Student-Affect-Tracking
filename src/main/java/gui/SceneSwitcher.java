package gui;

import gui.controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tasks.Session;

public class SceneSwitcher {

    public static void endScreen(Stage stage){
        try{

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SceneSwitcher.class.getResource("/fxml/SessionOver.fxml"));
            Parent root = loader.load();

            //get the controller for the view and set its task to be the next task.
//                    EndController controller = loader.getController();
//                    controller.setMyService(currentSession);


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception excep){
            excep.printStackTrace();
        }

    }
    public static void taskSwitch(Stage stage, Session session){
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SceneSwitcher.class.getResource(session.peekNextTask().fxmlLocation()));
            Parent root = loader.load();

            //get the controller for the view and set its task to be the next task.
            Controller controller = loader.getController();
            controller.setMyService(session);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception excep){
            excep.printStackTrace();
        }

    }
}
