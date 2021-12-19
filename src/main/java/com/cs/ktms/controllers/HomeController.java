package com.cs.ktms.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class HomeController extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("HomeScreen.fxml")));
			stage.initStyle(StageStyle.DECORATED);
			stage.setMaximized(false);
			stage.setTitle("Home");
			stage.setResizable(false);
			Scene home = new Scene(root);
			stage.setScene(home);
			stage.show();
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public void signIn(ActionEvent event) {
		try {
			Stage stage; Scene scene;
			Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("SignIn.fxml")));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Sign In");
			stage.initStyle(StageStyle.DECORATED);
			stage.setMaximized(false);
			stage.setResizable(false);
			stage.show();
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public void signUp(ActionEvent event) {
		try {
			Stage stage; Scene scene;
			Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("SignUp.fxml")));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Sign Up");
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