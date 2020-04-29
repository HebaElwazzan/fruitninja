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
import model.ArcadeGameState;
import model.GameInfo;
import model.LevelOneState;

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
		ButtonHandler.goToDifferentScreen(event, "/view/GameScreen.fxml");
		GameScreenController.setGameState(new LevelOneState());
	}

	public void arcadeButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/GameScreen.fxml");
		GameScreenController.setGameState(new ArcadeGameState());
	}

	public void leaderboardsButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/LeaderBoard.fxml");
	}
	
	public void soundButtonAction(ActionEvent event) {
		ButtonHandler.soundButtonAction(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		welcomeLabel.setText("Welcome, " + GameInfo.getInstance().getCurrentPlayer().getName());
	}
}
