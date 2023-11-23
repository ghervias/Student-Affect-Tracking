package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TaskController {
    public Task currentTask;
    @FXML
    public Text taskTitle;
    public Text taskDesc;
    public TextField answerField;

    public void updateDynamicText() {
        taskTitle.setText("Dynamic Text Updated!");
    }
    public void test(ActionEvent e) {
        System.out.println("test!");
    }
    public void getAnswer(ActionEvent e){
        String answer = answerField.getText();
        System.out.println("ANSWER: " + answer);
    }
    public void setMyService(Task currentTask) {
        this.currentTask = currentTask;
        taskDesc.setText(currentTask.getDescription());
    }
    //attempt to display task information here
}

