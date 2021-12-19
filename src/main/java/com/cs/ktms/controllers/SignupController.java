package com.cs.ktms.controllers;

import com.cs.ktms.models.User;
import com.cs.ktms.models.UserFactoryPattern;
import com.cs.ktms.views.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
	@FXML private TextField username;
	@FXML private TextField email;
	@FXML private PasswordField password;
	@FXML private ComboBox accountType;
	DBConnection dbConnection = DBConnection.getInstance();
	UserFactoryPattern userFactoryPattern  = new UserFactoryPattern();

	public void signup(ActionEvent event) throws IOException {
		User account = userFactoryPattern.getUser((String) accountType.getValue());
		account.setEmail(email.getText());
		account.setFirstname(username.getText().trim().split(" ")[0]);
		if (username.getText().split(" ").length <= 1)
			account.setLastname(" ");
        else
        	account.setLastname(username.getText().trim().split(" ")[1]);
		dbConnection.saveUser(account,password.getText());
		Stage stage; Scene scene;
		Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("HomeScreen.fxml")));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Home");
		stage.initStyle(StageStyle.DECORATED);
		stage.setMaximized(false);
		stage.setResizable(false);
		stage.show();
	}

	@Override // Add items into ComboBox
	public void initialize(URL url, ResourceBundle rb){
		accountType.getItems().addAll("ClubCoach", "TournamentOrganizer", "Referee");
		accountType.setValue("ClubCoach");
	}

	public void goToHome(ActionEvent event) throws IOException {
		Scene scene; Stage stage;
		Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("HomeScreen.fxml")));
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