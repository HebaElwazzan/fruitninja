package Main;

import javax.xml.bind.JAXBException;

import controller.ButtonHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.XMLFileHandler;



public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		    public void run() {
		        try {
					XMLFileHandler.saveFile("GameData.xml");
				} catch (JAXBException e) {
					ButtonHandler.alert();
					e.printStackTrace();
				}
		    }
		}));
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/SplashScreen.fxml"));
		
		Scene scene = new Scene(root);
		
		stage.initStyle(StageStyle.UNDECORATED);
		
		stage.setScene(scene);
		stage.show();
	}

}
