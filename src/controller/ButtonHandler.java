package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ButtonHandler {
	
	private Button button;
	private AnchorPane anchorPane;
	
	public static void quitButtonAction(ActionEvent event) {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
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
			//stage.setFullScreen(true);
		
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
			//stage.setFullScreen(true);

			anchorPane.getScene().getWindow().hide();
			
			stage.setScene(scene);
			stage.show();
		}
	}
}
