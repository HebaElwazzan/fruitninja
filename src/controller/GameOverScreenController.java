package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameModel;

public class GameOverScreenController implements Initializable {
	
	@FXML
	private Button okButton;
	
	private static GameModel gameModel;
	private static Stage stage;
	
	public static void setGameModel(GameModel gameModel) {
		GameOverScreenController.gameModel = gameModel;
	}
	
	public static void setGameScreen(BorderPane borderPane) {
		GameOverScreenController.stage = (Stage) borderPane.getScene().getWindow();
	}
	
	public void okButtonAction(ActionEvent event){
		ButtonHandler.returnButtonAction(event, gameModel);
		stage.close();
		ButtonHandler.goToDifferentScreen(event, "/view/MainMenu.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
