package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.GameInfo;
import model.GameModel;

/*
 * This class's purpose is to handle most button events and to allow easy reusability of duplicate actions.
 */
public class ButtonHandler {
		
	public static void quitButtonAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(ButtonHandler.class.getResource("/view/quitConfirmationScreen.fxml"));
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
			stage.initModality(Modality.APPLICATION_MODAL);

			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			alert();
		}
	}
	
	public static void newUserButtonAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(ButtonHandler.class.getResource("/view/NewUserScreen.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
			stage.initModality(Modality.APPLICATION_MODAL);
			
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			alert();
			e.printStackTrace();
		}
	}
	
	public static void alert() {
		try {
			Parent root = FXMLLoader.load(ButtonHandler.class.getResource("/view/alertBox.fxml"));
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
			stage.initModality(Modality.APPLICATION_MODAL);

			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			alert();
		}
	}


	public static void goToDifferentScreen(ActionEvent event, String fileName) {
		
		Parent root = null;
		try {
			root = FXMLLoader.load(ButtonHandler.class.getResource(fileName));
	        Scene scene = new Scene(root);
	        
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(scene);
	        window.show();
			
		} catch (IOException e) {
			e.printStackTrace();
			alert();
		}
		
	}
	
	public static void returnButtonAction(ActionEvent event, GameModel gameModel) {
		
		gameModel.generateNewAnimation();
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
	public static void pauseButtonAction(ActionEvent event, GameModel gameModel) {
		try {
			Parent root = FXMLLoader.load(ButtonHandler.class.getResource("/view/PauseMenu.fxml"));
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
			stage.initModality(Modality.APPLICATION_MODAL);
			
			PauseMenuController.sendGameModel(gameModel);

			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			alert();
			e.printStackTrace();
		}
	}

	public static void soundButtonAction(ActionEvent event, MediaPlayer mediaPlayer) {
		if(mediaPlayer.getStatus()==Status.PLAYING)
		{
			mediaPlayer.pause();
			
		}
		else
		{
			mediaPlayer.play();
			
		}
		
	}

	public static void goToGameOverScreen(GameModel gameModel) {
		
		GameOverScreenController.setGameModel(gameModel);
		if (GameInfo.getInstance().getCurrentPlayer() != null) {
			if (gameModel.getState().toString().equals("Arcade Mode")) {
				if (GameInfo.getInstance().getCurrentPlayer().getArcadeHighScore() < gameModel.getScore())
					GameInfo.getInstance().getCurrentPlayer().setArcadeHighScore(gameModel.getScore());
			} else {
				if (GameInfo.getInstance().getCurrentPlayer().getClassicHighScore() < gameModel.getScore())
					GameInfo.getInstance().getCurrentPlayer().setClassicHighScore(gameModel.getScore());
			}
		}
		
		try {
			
			Parent root = FXMLLoader.load(ButtonHandler.class.getResource("/view/GameOverScreen.fxml"));
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
			stage.initModality(Modality.APPLICATION_MODAL);
			
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			alert();
			e.printStackTrace();
		}
	}


}
