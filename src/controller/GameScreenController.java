package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBException;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Apple;
import model.Bomb;
import model.DangerousBomb;
import model.FatalBomb;
import model.Fruit;
import model.GameInfo;
import model.GameModel;
import model.GameObject;
import model.GameObjectFactory;
import model.GameObjectImplementation;
import model.GameState;
import model.LevelObserver;
import model.LivesObserver;
import model.ScoreObserver;
import model.TimerObserver;
import model.GameObject.ObjectType;


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

	@FXML
	private ImageView bonusImage;

	private static GameState gameState;
	GameModel gameModel;
	private AnimationTimer animationTimer;
	
	public void pauseButtonAction(ActionEvent event) {
		window = (Stage)((Node)event.getSource()).getScene().getWindow();
		ButtonHandler.pauseButtonAction(event, gameModel);

		//pause game (time and objects being thrown)
		gameModel.stopCurrentAnimation();
	}

	public static Stage getGameScreen() {
		return window;
	}


	public static void setGameState(GameState gameState) {
		GameScreenController.gameState = gameState;
	}
	
	public void gameUpdate() {
		
		for (int i = 0; i < gameModel.getGameObjects().size(); i++) {
			if (gameModel.getGameObjects().get(i) instanceof Fruit) {
				Fruit fruit = (Fruit) gameModel.getGameObjects().get(i);
				if (fruit.isSliced()) {
					if(fruit.getScoreOnSlicing() > 10)
						bonusImage.setVisible(true);
					else bonusImage.setVisible(false);
					gameModel.updateScore(fruit.getScoreOnSlicing());
					gameModel.getGameObjects().remove(i);
					
				} else if (fruit.hasMovedOffScreen()) {
					gameModel.updateLives(1);
					gameModel.getGameObjects().remove(i);
				}
				
			}
			else if (gameModel.getGameObjects().get(i) instanceof DangerousBomb) {
				DangerousBomb bomb = (DangerousBomb) gameModel.getGameObjects().get(i);
				if (bomb.isSliced()) {
					gameModel.updateLives(1);
					gameModel.updateScore(-5);
					gameModel.getGameObjects().remove(i);
				}
			} else if (gameModel.getGameObjects().get(i) instanceof FatalBomb) {
				FatalBomb bomb = (FatalBomb) gameModel.getGameObjects().get(i);
				if (bomb.isSliced()) {
					gameModel.updateLives(3);
					gameModel.setGameOver(true);
				}
			}
		}
		
		if (gameModel.getLives() == 0)
			gameModel.setGameOver(true);
		if (gameModel.isGameOver()) {
			gameModel.stopCurrentAnimation();
			GameOverScreenController.setGameScreen(root);
			ButtonHandler.goToGameOverScreen(gameModel);
			animationTimer.stop();
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		gameModel = new GameModel(GameScreenController.gameState);
		gameModel.setRoot(root);
		if (gameModel.getState().toString().equals("Arcade Mode"))
			highscoreLabel.setText("Highscore " + Integer.toString(GameInfo.getInstance().getCurrentPlayer().getArcadeHighScore()));
		else highscoreLabel.setText("Highscore " + Integer.toString(GameInfo.getInstance().getCurrentPlayer().getClassicHighScore()));

		bonusImage.setVisible(false);
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

		if (gameModel.getState().toString().equals("Arcade Mode")) {
			life1.setVisible(false);
			life2.setVisible(false);
			life3.setVisible(false);
		}

		//Start the timer according to game mode:
		gameModel.updateTime();

		//Create random objects at time intervals (the density and speed rely on the game state)
		gameModel.generateNewAnimation();

		//Update game data when an object is sliced or a bomb is detonated
		animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				gameUpdate();
			}
		};
		animationTimer.start();

		//Game over if time runs out in arcade mode or if all lives are lost in classic


		root.setOnDragDetected(e -> {
			root.startFullDrag();
		});
		
		//to ensure that program closes properly if closed unexpectedly from system instead of from quit button
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		    public void run() {
		        try {
					XMLFileHandler.saveFile("GameData.xml");
					gameModel.stopCurrentAnimation();
				} catch (JAXBException e) {
					ButtonHandler.alert();
					e.printStackTrace();
				}
		    }
		}));

	}
}
