package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.GameModel;

public class GameOverScreenController implements Initializable {
	
	@FXML
	private Button okButton;
	
	public void okButtonAction(ActionEvent event){
		ButtonHandler.returnButtonAction(event, new GameModel(null));
		GameScreenController.getGameScreen().close();
		ButtonHandler.goToDifferentScreen(event, "/view/MainMenu.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
