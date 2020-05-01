package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application{
	public static void main(String[] args) {
		//File f = new File("Fruit-Ninja-Theme-Song.mp3");
		//String absolute = f.getAbsolutePath();
		//System.out.println("Original path: " + f.getPath());
		//System.out.println("Absolute path: " + absolute);
		//System.out.println(MainMenuController.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		//String cwd = System.getProperty("user.dir");
		//System.out.println("Current working directory: " + cwd);
		launch(args);
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
