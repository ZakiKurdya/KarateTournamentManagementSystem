package com.cs.ktms.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class ClubCoachMainScreen {
	public void showScreen(ActionEvent event) {
		try {
			Stage stage; Scene scene;
			Parent root = FXMLLoader.load(Objects.requireNonNull(HomeScreen.class.getResource("PlayerAddition.fxml")));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Player Addition");
			stage.initStyle(StageStyle.DECORATED);
			stage.setMaximized(false);
			stage.setResizable(false);
			stage.show();
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
// Zaki Kurdya