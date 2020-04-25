package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class LeaderboardsController implements Initializable {
	
	@FXML
	private AnchorPane leaderboards;
	
	@FXML
	private Button backButton = new Button();
	
	@FXML
	private void backButtonAction(){
		ButtonHandler buttonHandler = new ButtonHandler(backButton, leaderboards);
		buttonHandler.ButtonAction();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				backButtonAction();				
			}
		});	
	}
}
