package gui.controllers;

import data.Blackboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tasks.DefaultTask;
import tasks.Session;
import tasks.Task;

import java.util.ArrayList;

public class EndController {
    @FXML
    Session session;
    @FXML
    TextField duration;
    @FXML
    TextField studentName;
    @FXML
    Text padText, affectText;

    public void setupBCI(Blackboard blackboard){
        blackboard.setDataText(padText, affectText);
    }




}
