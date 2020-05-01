package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Apple;
import model.ArcadeGameState;
import model.Fruit;
import model.GameActions;
import model.GameActionsImplementation;
import model.GameInfo;
import model.GameModel;
import model.GameObject;
import model.GameObjectFactory;
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
	
	public void pauseButtonAction(ActionEvent event) {
		window = (Stage)((Node)event.getSource()).getScene().getWindow();
		ButtonHandler.pauseButtonAction(event);
	}
	
	public static Stage getGameScreen() {
		return window;
	}
	
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
	
	private ParallelTransition parallelTransition = new ParallelTransition();
	
	public void pauseButtonAction( ) {
		
	}
	
	private ImageView createNode(GameObject gameObject) throws IOException {
		Image image = SwingFXUtils.toFXImage(gameObject.getBufferedImages()[0], null);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setOnMouseDragOver(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				try {
					Image image = SwingFXUtils.toFXImage(gameObject.getBufferedImages()[1], null);
					imageView.setImage(image);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gameObject.setSliced(true);	
			}
		});
		return imageView;
	}
	
	private ParallelTransition animateNode(ImageView imageView, double rate) {
		Path path = new Path();
		Random random = new Random();
		int startingPosition = random.nextInt(1100);
		PathTransition pathTransition = new PathTransition();
		MoveTo moveTo = new MoveTo(); 
		QuadCurveTo quadCurveTo = new QuadCurveTo();
		
		
		moveTo.setX(startingPosition); 
		moveTo.setY(1000); 
 

		quadCurveTo.setX(startingPosition + random.nextInt(300)); 
		quadCurveTo.setY(1000); 
		quadCurveTo.setControlX((startingPosition + quadCurveTo.getX())/2);  
		quadCurveTo.setControlY(-700);      

		path.getElements().add(moveTo); 
		path.getElements().add(quadCurveTo);

		pathTransition.setNode(imageView);
		pathTransition.setPath(path);
		pathTransition.setRate(rate);
		pathTransition.setDuration(Duration.millis(10000));
		
		RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), imageView);
		rotateTransition.setByAngle(360f);
		rotateTransition.setCycleCount(Animation.INDEFINITE);
		
		return new ParallelTransition(rotateTransition, pathTransition);
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

		//gameModel.updateTime();	

		GameActions gameActions = new GameActionsImplementation();
		try {
			//createNode(GameObjectFactory.getObject(GameObjectFactory.createRandomFruit()));
			ImageView node = createNode(GameObjectFactory.getObject(ObjectType.APPLE));
			root.getChildren().add(node);
			parallelTransition.getChildren().add(animateNode(node, gameModel.getState().setVelocityOfObjects()));
			parallelTransition.play();
			gameModel.updateTime();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		root.setOnDragDetected(e -> {
			root.startFullDrag();
		});

	}
}
