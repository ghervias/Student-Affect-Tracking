package com.example.gui.controllers;

import com.example.gui.CodeEditor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TestController {
    @FXML
    public CodeEditor myEditor = new CodeEditor("Hi mom");
    @FXML
    public void test(ActionEvent e){
        System.out.println("test!");
    }
}
