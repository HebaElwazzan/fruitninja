package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.GameModel;

public class PauseMenuController implements Initializable {

	@FXML
	private Button quitButton;
	
	@FXML
	private Button returnButton;
	
	@FXML
	private Button soundButton;
	
	private static GameModel gameModel;
	
	public void quitButtonAction(ActionEvent event){
		ButtonHandler.returnButtonAction(event, gameModel);
		GameScreenController.getGameScreen().close();
		ButtonHandler.goToDifferentScreen(event, "/view/MainMenu.fxml");
		gameModel.getTime().getTimeline().stop();
	}
	
	public void returnButtonAction(ActionEvent event) {
		ButtonHandler.returnButtonAction(event, gameModel);
	}
	
	public void soundButtonAction(ActionEvent event) {
		ButtonHandler.soundButtonAction(event, MainMenuController.mediaPlayer);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	public static void sendGameModel(GameModel gameModel) {
		
		PauseMenuController.gameModel = gameModel;
		
	}

}
