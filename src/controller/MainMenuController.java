package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.ArcadeGameState;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
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
	
	@FXML
	private Button soundbButton;
	
	public static String path = System.getProperty("user.dir") + "/resources/sound/Fruit-Ninja-Theme-Song.mp3";

	public static Media media = new Media(new File(path).toURI().toString());
	
	public static MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	
	public void quitButtonAction(ActionEvent event){
		ButtonHandler.quitButtonAction(event);
	}

	public void changePlayerButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/UserManager.fxml");
	}
	
	public void helpButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/helpMenu.fxml");
	}

	public void classicButtonAction(ActionEvent event){
		GameScreenController.setGameState(new LevelOneState());
		ButtonHandler.goToDifferentScreen(event, "/view/GameScreen.fxml");
		
	}

	public void arcadeButtonAction(ActionEvent event){
		GameScreenController.setGameState(new ArcadeGameState());
		ButtonHandler.goToDifferentScreen(event, "/view/GameScreen.fxml");
		
	}

	public void leaderboardsButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/LeaderBoard.fxml");
	}
	
	public void soundButtonAction(ActionEvent event) {
		ButtonHandler.soundButtonAction(event, mediaPlayer);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		welcomeLabel.setText("Welcome, " + GameInfo.getInstance().getCurrentPlayer().getName());
		
		if(mediaPlayer.getStatus()!=Status.PLAYING||mediaPlayer.getStatus()!=Status.PAUSED)
		{
			mediaPlayer.play();
		}
		
	}
}
