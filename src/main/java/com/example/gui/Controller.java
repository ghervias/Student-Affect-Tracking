package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    public CodeEditor myEditor = new CodeEditor("Hi mom");
    @FXML
    public void test(ActionEvent e){
        System.out.println("test!");
    }
}
