package com.cs.ktms.controllers;

import com.cs.ktms.models.Player;
import com.cs.ktms.views.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerAdditionController implements Initializable {
	@FXML private TextField firstName;
	@FXML private TextField lastName;
	@FXML private TextField email;
	@FXML private ComboBox gender;
	@FXML private DatePicker DOB;
	@FXML private TextField weight;
	@FXML private TextField height;
	@FXML private Label result;
	DBConnection dbConnection = DBConnection.getInstance();

	public void savePlayer() {
		Player player = new Player();
		player.setPlayerName(firstName.getText() + " " + lastName.getText());
		player.setPlayerEmail(email.getText());
		if (((String) gender.getValue()).equalsIgnoreCase("male"))
			player.setPlayerGender('M');
		else player.setPlayerGender('F');
		player.setPlayerDOB(DOB.getValue());
		player.setPlayerHeight(Byte.parseByte(height.getText()));
		player.setPlayerWeight(Byte.parseByte(weight.getText()));
		dbConnection.insertPlayer(player);
		firstName.setText(""); lastName.setText(""); email.setText("");
		DOB.setValue(null); weight.setText(""); height.setText("");
		showPlayers();
	}

	@Override // Add items into ComboBox
	public void initialize(URL url, ResourceBundle rb){
		gender.getItems().addAll("Male", "Female");
		gender.setValue("Male");
	}

	public void showPlayers() {
		for (Player player: dbConnection.selectPlayers()) {
			result.setText(result.getText()+player.toString());
		}
	}
}
// Zaki Kurdya