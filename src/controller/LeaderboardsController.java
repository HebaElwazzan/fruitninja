package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Game;
import model.Player;

public class LeaderboardsController implements Initializable {
	
	
	@FXML
	private Button backButton;
	
	@FXML
	private Label levelOneLabel;
	
	@FXML
	private Label levelTwoLabel;
	
	@FXML
	private Label levelThreeLabel;
	
	@FXML
	private Label arcadeModeLabel;
	
	public void backButtonAction(ActionEvent event){
		ButtonHandler.goToDifferentScreen(event, "/view/MainMenu.fxml");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Player player;
		player = Game.getInstance().getLevelOneTopPlayer();
		levelOneLabel.setText(player.getName() + "\t" + player.getClassicHighScore());
		
		player = Game.getInstance().getLevelTwoTopPlayer();
		levelTwoLabel.setText(player.getName() + "\t" + player.getClassicHighScore());
		
		player = Game.getInstance().getLevelThreeTopPlayer();
		levelThreeLabel.setText(player.getName() + "\t" + player.getClassicHighScore());
		
		player = Game.getInstance().getArcadeModeTopPlayer();
		arcadeModeLabel.setText(player.getName() + "\t" + player.getArcadeHighScore());

	}
}
