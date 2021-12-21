package com.cs.ktms.controllers;

import com.cs.ktms.models.Player;
import com.cs.ktms.views.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PlayerAdditionController implements Initializable {
	@FXML private TextField firstName;
	@FXML private TextField lastName;
	@FXML private TextField email;
	@FXML private ComboBox gender;
	@FXML private DatePicker DOB;
	@FXML private TextField weight;
	@FXML private TextField height;
	@FXML private Label result;
	@FXML private ComboBox team;
	DBConnection dbConnection = DBConnection.getInstance();
	Player player = new Player();

	public void savePlayer() {
		player.setPlayerName(firstName.getText() + " " + lastName.getText());
		player.setPlayerEmail(email.getText());
		if (((String) gender.getValue()).equalsIgnoreCase("male"))
			player.setPlayerGender('M');
		else player.setPlayerGender('F');
		player.setPlayerDOB(DOB.getValue());
		player.setPlayerHeight(Byte.parseByte(height.getText()));
		player.setPlayerWeight(Byte.parseByte(weight.getText()));
		dbConnection.insertPlayer(player, (String)team.getValue());
		firstName.setText(""); lastName.setText(""); email.setText("");
		DOB.setValue(null); weight.setText(""); height.setText("");
		showPlayers((String)team.getValue());
		gender.setValue(null); team.setValue(null);
	}

	@Override // Add items into ComboBox
	public void initialize(URL url, ResourceBundle rb){
		gender.getItems().addAll("Male", "Female");
		team.getItems().addAll(dbConnection.showTeams());
	}

	public void showPlayers(String team) {
		result.setText("");
		for (Player teamPlayer: dbConnection.selectTeamPlayers(team)) {
			result.setText(result.getText() + teamPlayer.toString());
		}
	}

	public void goToMain(ActionEvent event) throws IOException {
		Scene scene; Stage stage;
		Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("ClubCoachMainScreen.fxml")));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Club Coach");
		stage.setMaximized(false);
		stage.setResizable(false);
		stage.show();
	}
}
// Zaki Kurdya