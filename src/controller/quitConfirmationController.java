package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class quitConfirmationController implements Initializable {

	@FXML
	Button yesButton;
	
	@FXML
	Button noButton;
	
public void yesButtonAction(ActionEvent event) {
		System.exit(0);
	}
	
	public void noButtonAction(ActionEvent event) {
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
	}

}
