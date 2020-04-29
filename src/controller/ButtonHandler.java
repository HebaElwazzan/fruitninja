package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	
	public static void returnButtonAction(ActionEvent event) {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
	public static void pauseButtonAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(ButtonHandler.class.getResource("/view/PauseMenu.fxml"));
			
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

	public static void soundButtonAction(ActionEvent event, MediaPlayer mediaPlayer) {
		if(mediaPlayer.isMute())
		{
			mediaPlayer.setMute(false);
		}
		else
		{
			mediaPlayer.setMute(true);
		}
		
	}


}
