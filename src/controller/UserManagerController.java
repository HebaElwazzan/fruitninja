package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Game;
import model.Player;

public class UserManagerController implements Initializable{
	
	@FXML
	private Button newUserButton;
	
	@FXML
	private Button quitButton;
	
	@FXML 
	private Button guestButton;
	
	@FXML
	private Button goButton;
	
	@FXML
	private ListView<Player> listOfPlayers;
	
	public void newUserAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/NewUserScreen.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.initStyle(StageStyle.UNDECORATED);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void quitButtonAction(ActionEvent event) {
		ButtonHandler.quitButtonAction(event);
	}
	
	public void loadPlayers()
    {
        listOfPlayers.getItems().addAll(Game.getInstance().getPlayers());
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listOfPlayers.setStyle("-fx-font: 20px 'Engravers MT';"
				+ "-fx-border-style: solid;"
				+ "-fx-border-width: 10;");
		Game.getInstance();
		loadPlayers();
	}
	
	

}
