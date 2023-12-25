package gui.controllers;

import data.Blackboard;
import gui.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tasks.CodingTask;
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
    @FXML
    Text padText, affectText;
    Blackboard blackboard;

    public Session getSession(){
        return this.session;
    }

    public void createSession(){
        ArrayList<Task> listOfTasks;
//        Task task = new DefaultTask("1 + 1", "2");
//        Task task2 = new DefaultTask("2 + 2", "4");
//        Task task3 = new DefaultTask("5 - 5", "0");
        Task task4 = new CodingTask("Write and call a function called 'square()' that returns the square root of an input.", "10", "print(square(100))");
        Task task5 = new DefaultTask("5 * 5", "25");
        Task task6 = new CodingTask("2^5", "32", "");
        listOfTasks = new ArrayList<>();
//        listOfTasks.add(task);
//        listOfTasks.add(task2);
//        listOfTasks.add(task3);
        listOfTasks.add(task4);
        listOfTasks.add(task5);
        listOfTasks.add(task6);
        this.session = new Session(Integer.parseInt(duration.getText()), listOfTasks, studentName.getText());
        blackboard.setSession(this.session);
    }

    public void startSession(ActionEvent e){
        createSession();
        this.session.startSession();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        SceneSwitcher.taskSwitch(stage, session);
//        try {
//            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/fxml/PythonTask.fxml"));
//            Parent root = loader.load();
//
//            //get the controller for the view and set its task to be the next task.
//            Controller controller = loader.getController();
//            controller.setMyService(this.session);
//
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        }
//        catch (Exception excep){
//            excep.printStackTrace();
//        }
    }
    public void setupBCI(Blackboard blackboard){
        this.blackboard = blackboard;
        blackboard.setDataText(padText, affectText);
    }




}
