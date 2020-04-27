package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import com.sun.javafx.fxml.expression.LiteralExpression;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
		ButtonHandler.goToMainMenu(event);
	}
	
	public void goButtonAction(ActionEvent event) {
		if(listOfPlayers.getSelectionModel().getSelectedItem() == null) {
			errorLabel.setText("Please choose a player name.");
		} else {
			Game.getInstance().setCurrentPlayer(Game.getInstance().getPlayers().get(listOfPlayers.getSelectionModel().getSelectedIndex()));
			ButtonHandler.goToMainMenu(event);
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
