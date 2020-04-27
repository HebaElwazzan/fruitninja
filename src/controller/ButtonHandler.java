package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ButtonHandler {
	
	private Button button;
	private AnchorPane anchorPane;
	

	
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
		
	public ButtonHandler(Button button, AnchorPane anchorPane) {
		super();
		this.button = button;
		this.anchorPane = anchorPane;
	}

	public void ButtonAction() 
	{
		if(button.getText().equals("Arcade"))
		{
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("/view/GameScreen.fxml"));

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
		
			stage.setScene(scene);
			stage.show();
			
			anchorPane.getScene().getWindow().hide();
		}
		else if(button.getText().equals("Classic"))
		{
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("/view/GameScreen.fxml"));

			} catch (IOException e) {
				e.printStackTrace();
			}
				
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
			//stage.setFullScreen(true);
			
			stage.setScene(scene);
			stage.show();
				
			anchorPane.getScene().getWindow().hide();	
		}
		else if(button.getText().equals("Quit"))
		{
			 Stage stage = (Stage) button.getScene().getWindow();
			 stage.close();
		}
		else if(button.getText().equals("Change Player"))
		{
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("/view/UserManager.fxml"));

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
			//stage.setFullScreen(true);

			anchorPane.getScene().getWindow().hide();
			
			stage.setScene(scene);
			stage.show();
		}
		else if(button.getText().equals("Leaderboards"))
		{
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("/view/LeaderBoard.fxml"));

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);
			//stage.setFullScreen(true);

			anchorPane.getScene().getWindow().hide();
			
			stage.setScene(scene);
			stage.show();
		}
		else if(button.getText().equals(""))
		{
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.initStyle(StageStyle.UNDECORATED);

			anchorPane.getScene().getWindow().hide();
			
			stage.setScene(scene);
			stage.show();
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

	public static void goToMainMenu(ActionEvent event) {
		
		Parent root = null;
		try {
			root = FXMLLoader.load(ButtonHandler.class.getResource("/view/MainMenu.fxml"));
	        Scene scene = new Scene(root);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(scene);
	        window.show();
			
		} catch (IOException e) {
			alert();
		}
		
		
	}
}
