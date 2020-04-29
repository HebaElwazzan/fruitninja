package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameScreenController implements Initializable {
	
	@FXML
	private Button pauseButton;
	
	@FXML
	private AnchorPane gameScreen;
	
	public void pauseButtonAction(ActionEvent event) {
		ButtonHandler.pauseButtonAction(event);
	}
	
	public void closeGameScreen() {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
