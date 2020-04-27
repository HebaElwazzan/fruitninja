package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
	private Label errorLabel;
	
	@FXML
	private ListView<Player> listOfPlayers;
	
	public void newUserAction(ActionEvent event) {
			ButtonHandler.newUserButtonAction(event);
	}
	
	public void quitButtonAction(ActionEvent event) {
			ButtonHandler.quitButtonAction(event);
	}
	
	public void guestButtonAction(ActionEvent event) {
		Player player = new Player("Guest", 0, 0);
		Game.getInstance().setCurrentPlayer(player);
		ButtonHandler.goToDifferentScreen(event, "/view/MainMenu.fxml");
	}
	
	public void goButtonAction(ActionEvent event) {
		if(listOfPlayers.getSelectionModel().getSelectedItem() == null) {
			errorLabel.setText("Please choose a player name.");
		} else {
			Game.getInstance().setCurrentPlayer(Game.getInstance().getPlayers().get(listOfPlayers.getSelectionModel().getSelectedIndex()));
			ButtonHandler.goToDifferentScreen(event, "/view/MainMenu.fxml");
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		listOfPlayers.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listOfPlayers.setStyle("-fx-font: 20px 'Engravers MT';"
				+ "-fx-border-style: solid;"
				+ "-fx-border-width: 10;");
		ListProperty<Player> listProperty = new SimpleListProperty<>();
		listProperty.set(Game.getInstance().getPlayers());
		listOfPlayers.itemsProperty().bind(listProperty);
		Game.getInstance();
	}
	
	

}
