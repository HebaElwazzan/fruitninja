package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashScreenController implements Initializable {

	@FXML
	private AnchorPane splashScreen;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new SplashScreen().start();
	}

	class SplashScreen extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(7000);

				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						Parent root = null;
						try {
							root = FXMLLoader.load(getClass().getResource("/view/PlayerNameScreen.fxml"));

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Scene scene = new Scene(root);
						Stage stage = new Stage();

						stage.initStyle(StageStyle.UNDECORATED);
						stage.setFullScreen(true);

						stage.setScene(scene);
						stage.show();

						splashScreen.getScene().getWindow().hide();


					}
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}

	}

}

