package com.cs.ktms.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RefereeController {
    public void goToHome(ActionEvent event) throws IOException {
        Stage stage; Scene scene;
        Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("HomeScreen.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
    }
}
// Zaki Kurdya