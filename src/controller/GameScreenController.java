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

	public void pauseButtonAction(ActionEvent event) {
		window = (Stage)((Node)event.getSource()).getScene().getWindow();
		ButtonHandler.pauseButtonAction(event);
	}

	public static Stage getGameScreen() {
		return window;
	}


	public static void setGameState(GameState gameState) {
		GameScreenController.gameState = gameState;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GameModel gameModel = new GameModel(GameScreenController.gameState);
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

		gameModel.updateTime();
		GameObjectImplementation apple = new Apple();
		root.getChildren().add(apple.getImageView());
		apple.move(gameModel.setVelocityOfObjects());

		root.setOnDragDetected(e -> {
			root.startFullDrag();
		});

	}
}
