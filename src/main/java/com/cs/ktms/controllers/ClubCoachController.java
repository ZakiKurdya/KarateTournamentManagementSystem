package com.cs.ktms.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClubCoachController {
	public void showPlayerScreen(ActionEvent event) {
		try {
			Stage stage; Scene scene;
			Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("PlayerAddition.fxml")));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Player Addition");
			stage.setMaximized(false);
			stage.setResizable(false);
			stage.show();
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public void showTeamScreen(ActionEvent event) {
		try {
			Stage stage; Scene scene;
			Parent root = FXMLLoader.load(Objects.requireNonNull(ClubCoachController.class.getResource("TeamCreation.fxml")));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Team Creation");
			stage.setMaximized(false);
			stage.setResizable(false);
			stage.show();
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public void goToHome(ActionEvent event) throws IOException {
		Scene scene; Stage stage;
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