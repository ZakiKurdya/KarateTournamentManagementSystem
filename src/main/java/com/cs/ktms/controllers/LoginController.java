package com.cs.ktms.controllers;

import com.cs.ktms.views.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
	DBConnection dbConnection = DBConnection.getInstance();
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Label error;

	public void login(ActionEvent event) throws IOException {
		if (dbConnection.verifyUser(username.getText(), password.getText())){
			if (dbConnection.getAccountType(username.getText()).equals("ClubCoach")){
				Stage stage; Scene scene;
				Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("ClubCoachMainScreen.fxml")));
				stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Club Coach");
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.show();
			}else if (dbConnection.getAccountType(username.getText()).equals("TournamentOrganizer")){
				Stage stage; Scene scene;
				Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("TournamentOrganizerMainScreen.fxml")));
				stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Tournament Organizer");
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.show();
			}else {
				Stage stage; Scene scene;
				Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("RefereeMainScreen.fxml")));
				stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Referee");
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.show();
			}
		}else error.setText("Incorrect email or password");
	}

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