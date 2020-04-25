package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainMenuController implements Initializable{
		
	@FXML
	private AnchorPane mainMenu;
	
	@FXML
	private Button quitButton = new Button("Quit");
	
	@FXML
	private Button changePlayerButton = new Button("Change Player");
	
	@FXML
	private Button classicButton = new Button("Classic");
	
	@FXML
	private Button arcadeButton = new Button("Arcade");
	
	@FXML
	private Button leaderboardsButton = new Button("Leaderboards");

	@FXML
	private void quitButtonAction(){
		ButtonHandler buttonHandler = new ButtonHandler(quitButton, mainMenu);
		buttonHandler.ButtonAction();
	}
	
	@FXML
	private void changePlayerButtonAction(){
		ButtonHandler buttonHandler = new ButtonHandler(changePlayerButton, mainMenu);
		buttonHandler.ButtonAction();
	}
	
	@FXML
	private void classicButtonAction(){
		ButtonHandler buttonHandler = new ButtonHandler(classicButton, mainMenu);
		buttonHandler.ButtonAction();
	}
	
	@FXML
	private void arcadeButtonAction(){
		ButtonHandler buttonHandler = new ButtonHandler(arcadeButton, mainMenu);
		buttonHandler.ButtonAction();
	}
	
	@FXML
	private void leaderboardsButtonAction(){
		ButtonHandler buttonHandler = new ButtonHandler(leaderboardsButton, mainMenu);
		buttonHandler.ButtonAction();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				quitButtonAction();				
			}
		});
		
		changePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				changePlayerButtonAction();				
			}
		});
		
		classicButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				classicButtonAction();				
			}
		});

		arcadeButton.setOnAction(new EventHandler<ActionEvent>() {
	
			@Override
			public void handle(ActionEvent event) {
				arcadeButtonAction();		
			}
		});
		
		leaderboardsButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				leaderboardsButtonAction();		
			}
		});
	}
}
