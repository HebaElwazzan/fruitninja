package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PlayerNameScreenController implements Initializable{

	@FXML
	private Button exitButton = new Button("Exit");
	
	@FXML
	private void exitButtonAction(){
	  Stage stage = (Stage) exitButton.getScene().getWindow();
	  stage.close();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				exitButtonAction();
				
			}
		});
	}
	

}
