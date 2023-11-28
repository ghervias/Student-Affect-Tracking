package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tasks.DefaultTask;
import tasks.Session;
import tasks.Task;

import java.util.ArrayList;

public class SessionSetupController {
    @FXML
    Session session;
    @FXML
    TextField duration;
    @FXML
    TextField studentName;

    public Session getSession(){
        return this.session;
    }

    public void createSession(){
        ArrayList<Task> listOfTasks;
        Task task = new DefaultTask("1 + 1", "2");
        Task task2 = new DefaultTask("2 + 2", "4");
        Task task3 = new DefaultTask("5 - 5", "0");
        listOfTasks = new ArrayList<>();
        listOfTasks.add(task);
        listOfTasks.add(task2);
        listOfTasks.add(task3);
        this.session = new Session(Integer.parseInt(duration.getText()), listOfTasks, studentName.getText());
    }

    public void startSession(ActionEvent e){
        createSession();
        this.session.startSession();
        try {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/MathTask.fxml"));
            Parent root = loader.load();

            //get the controller for the view and set its task to be the next task.
            Controller controller = loader.getController();
            controller.setMyService(this.session);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception excep){
            excep.printStackTrace();
        }
    }




}
