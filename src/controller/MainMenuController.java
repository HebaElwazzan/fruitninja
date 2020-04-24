package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController implements Initializable{
	
	@FXML
	Button quitButton = new Button("Quit");
	
	@FXML
	private void quitButtonAction(){
	  Stage stage = (Stage) quitButton.getScene().getWindow();
	  stage.close();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				quitButtonAction();
				
			}
		});
	}
	

}
