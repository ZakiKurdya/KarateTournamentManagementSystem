package com.cs.ktms.controllers;
import com.cs.ktms.models.Team;
import com.cs.ktms.views.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class TeamController implements Initializable{
    @FXML private TextField teamName;
    @FXML private TextField max;
    @FXML private ComboBox type;
    DBConnection dbConnection = DBConnection.getInstance();

    public void saveTeam(ActionEvent event) throws IOException {
        Team team = new Team();
        Random prng = new Random();
        int id = 100000 + prng.nextInt(900000);
        team.setTeamID(((String) type.getValue()).substring(0,3)+"_"+id);
        team.setTeamName(teamName.getText());
        team.setTeamMaxNumber(Byte.parseByte(max.getText()));
        team.setTeamCategory((String) type.getValue());
        dbConnection.insertTeam(team);
        Stage stage; Scene scene;
        Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("ClubCoachMainScreen.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Club Coach");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
    }

    @Override // Add items into ComboBox
    public void initialize(URL url, ResourceBundle rb){
        type.getItems().addAll("Kata", "Kumite");
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