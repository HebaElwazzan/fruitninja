package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Apple;
import model.GameModel;
import model.GameObjectImplementation;
import model.GameState;
import model.LevelObserver;
import model.LivesObserver;
import model.ScoreObserver;
import model.TimerObserver;


public class GameScreenController implements Initializable {

	@FXML 
	private BorderPane root;

	@FXML
	private Button pauseButton;

	@FXML
	private AnchorPane gameScreen;

	private static Stage window;

	@FXML
	private Label scoreLabel;

	@FXML
	private Label highscoreLabel;

	@FXML
	private Label timerLabel;

	@FXML
	private Label levelLabel;

	@FXML
	private ImageView life1;

	@FXML
	private ImageView life2;

	@FXML
	private ImageView life3;

	private List<ImageView> gameObjectsImages = new ArrayList<>();

	private static GameState gameState;
	GameModel gameModel;

	public void pauseButtonAction(ActionEvent event) {
		window = (Stage)((Node)event.getSource()).getScene().getWindow();
		ButtonHandler.pauseButtonAction(event, gameModel);
		
		//pause game (time and objects being thrown)
		gameModel.getTime().getTimeline().pause();
	}

	public static Stage getGameScreen() {
		return window;
	}


	public static void setGameState(GameState gameState) {
		GameScreenController.gameState = gameState;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gameModel = new GameModel(GameScreenController.gameState);
		ImageView[] lives = new ImageView[3];
		lives[0] = life1;
		lives[1] = life2;
		lives[2] = life3;

		LevelObserver levelObserver = new LevelObserver(levelLabel, gameModel);
		TimerObserver timerObserver = new TimerObserver(timerLabel);
		LivesObserver livesObserver = new LivesObserver(lives);
		ScoreObserver scoreObserver = new ScoreObserver(scoreLabel);

		gameModel.addObserver(levelObserver);
		gameModel.addObserver(timerObserver);
		gameModel.addObserver(livesObserver);
		gameModel.addObserver(scoreObserver);

		//Start the timer according to game mode:
		gameModel.updateTime();
		
		//Create random objects at time intervals (the density and speed rely on the game state)

		//Add objects to the array which will be added to the root 
		
		//Update game data when an object is sliced or a bomb is detonated
		
		//Game over if time runs out in arcade mode or if all lives are lost in classic
		

		root.setOnDragDetected(e -> {
			root.startFullDrag();
		});

	}
}
