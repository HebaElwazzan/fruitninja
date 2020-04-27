package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Game;

public class MainMenuController implements Initializable{

	@FXML
	private Button quitButton;

	@FXML
	private Button changePlayerButton;
	
	@FXML
	private Button helpButton;

	@FXML
	private Button classicButton;

	@FXML
	private Button arcadeButton;

	@FXML
	private Button leaderboardsButton;

	@FXML
	private Label welcomeLabel;

	public void quitButtonAction(ActionEvent event){
		ButtonHandler.quitButtonAction(event);
	}

	public void changePlayerButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/UserManager.fxml");
	}
	
	public void helpButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "");
	}

	public void classicButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/GameScreen/fxml");
		//TODO: modify game state to classic
	}

	public void arcadeButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/GameScreen");
		//TODO: modify game state to arcade
	}

	public void leaderboardsButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/LeaderBoard.fxml");
	}
	
	public void soundButtonAction(ActionEvent event) {
		ButtonHandler.soundButtonAction(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		welcomeLabel.setText("Welcome, " + Game.getInstance().getCurrentPlayer().getName());
	}
}
