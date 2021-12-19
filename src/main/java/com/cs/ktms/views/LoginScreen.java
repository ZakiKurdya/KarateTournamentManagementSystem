package com.cs.ktms.views;

import com.cs.ktms.DataStorage.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;


public class LoginScreen {
	DBConnection dbConnection = new DBConnection();
	@FXML private TextField username;
	@FXML private PasswordField password;
	public void login(ActionEvent event) throws IOException {
		if (dbConnection.verifyUser(username.getText(), password.getText())){
			Stage stage; Scene scene;
			Parent root = FXMLLoader.load(Objects.requireNonNull(HomeScreen.class.getResource("ClubCoachMainScreen.fxml")));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Club Coach");
			stage.initStyle(StageStyle.DECORATED);
			stage.setMaximized(false);
			stage.setResizable(false);
			stage.show();
		}
	}

	public void alert() { // to show an error
		throw new UnsupportedOperationException();
	}

	public void goToHome(ActionEvent event) throws IOException {
		Stage stage; Scene scene;
		Parent root = FXMLLoader.load(Objects.requireNonNull(HomeScreen.class.getResource("HomeScreen.fxml")));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Home");
		stage.initStyle(StageStyle.DECORATED);
		stage.setMaximized(false);
		stage.setResizable(false);
		stage.show();
	}
}
// Zaki Kurdya