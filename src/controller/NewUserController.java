package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Game;
import model.Player;

public class NewUserController implements Initializable {

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField newUserTextField;
	
	@FXML
	private Label errorLabel;

	public void cancelButtonAction(ActionEvent event) {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}


	public void confirmButtonAction(ActionEvent event) {
		String name = newUserTextField.getText();
				if (name.isEmpty()) {
					errorLabel.setText("Please enter a name.");
				} else {
					Player player = new Player(name, 0, 0);
					Game.getInstance().getPlayers().add(player);
					cancelButtonAction(event);
				}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
