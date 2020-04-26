package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserManagerController implements Initializable{
	
	@FXML
	private Button newUserButton;
	
	public void newUserAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/NewUserScreen.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.initStyle(StageStyle.UNDECORATED);
		
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

}
