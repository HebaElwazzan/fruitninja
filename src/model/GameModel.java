package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import controller.ButtonHandler;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;

public class GameModel extends Subject{
	
	private GameState gameState;
	private BorderPane root;
	private int score = 0;
	private Time time;
	private int lives = 3;
	private Timer fruitTimer = new Timer();
	private Timer bombTimer = new Timer();
	private boolean gameOver = false;
	private List<GameObjectImplementation> gameObjects = new ArrayList<>();

	public GameModel(GameState gameState) {
		this.gameState = gameState;
		time = new Time();
	}

	public void updateScore(int incrementToScore) {
		score += incrementToScore;
		notifyAllObservers(new GameScreenLabel(gameState.toString(), time.toString(), lives, Integer.toString(score)));
	}
	public void updateTime() {
		gameState.updateTime(time, this);

	};

	public void updateLives(int livesDecrement) {
		lives = gameState.updateLives(livesDecrement, lives);
		notifyAllObservers(new GameScreenLabel(gameState.toString(), time.toString(), lives, Integer.toString(score)));
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}


	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public double setVelocityOfObjects() {
		return gameState.setVelocityOfObjects();
	}

	public int setMaxNumberOfSimultaneousFruits() {
		return gameState.setMaxNumberOfSimultaneousFruits();
	}

	public int setMaxNumberOfSimultaneousBombs() {
		return gameState.setMaxNumberOfSimultaneousBombs();
	}

	public int setTimeBetweenBombs() {
		return gameState.setTimeBetweenBombs();
	}
	public int setTimeBetweenFruits() {
		return gameState.setTimeBetweenFruits();
	}


	public GameState getState() {
		return gameState;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public List<GameObjectImplementation> getGameObjects() {
		return this.gameObjects;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}


	private void generateFruits() throws InterruptedException {
		for (int i = 0; i < (new Random().nextInt(this.setMaxNumberOfSimultaneousFruits()) + 1); i++) {
			Fruit fruit = (Fruit) GameObjectFactory.getObject(GameObjectFactory.createRandomFruit());
			this.getGameObjects().add(fruit);
			root.getChildren().add(this.getGameObjects().get(this.getGameObjects().size() - 1).getImageView());
			fruit.move(this.setVelocityOfObjects());
		}
	}

	private TimerTask generateFruitTask () {
		return new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						try {
							generateFruits();
						} catch (InterruptedException e) {
							ButtonHandler.alert();
							e.printStackTrace();
						}
					}
				});
			}
		};
	}

	private void generateBombs() throws InterruptedException {
		for (int i = 0; i < (new Random().nextInt(this.setMaxNumberOfSimultaneousBombs()) + 1); i++) {
			Bomb bomb = (Bomb) GameObjectFactory.getObject(GameObjectFactory.createRandomBomb());
			this.getGameObjects().add(bomb);
			root.getChildren().add(this.getGameObjects().get(this.getGameObjects().size() - 1).getImageView());
			bomb.move(this.setVelocityOfObjects());
		}
	}

	private TimerTask generateBombTask () {
		return new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						try {
							generateBombs();
						} catch (InterruptedException e) {
							ButtonHandler.alert();
							e.printStackTrace();
						}
					}
				});
			}
		};
	}

	public void generateNewAnimation() {
		time.getTimeline().play();
		for (int i = 0; i < gameObjects.size(); i++) 
			gameObjects.get(i).getParallelTransition().play();
		this.fruitTimer = new Timer();
		this.fruitTimer.scheduleAtFixedRate(this.generateFruitTask(), 0L, 1000*(this.setTimeBetweenFruits()) + 1);
		this.bombTimer = new Timer();
		this.bombTimer.scheduleAtFixedRate(this.generateBombTask(), 1000*(long)(new Random()).nextInt(this.setTimeBetweenBombs()) + 1, 1000*this.setTimeBetweenBombs());



	}

	public void stopCurrentAnimation() {
		for (int i = 0; i < this.gameObjects.size(); i++) 
			gameObjects.get(i).getParallelTransition().pause();
		this.time.getTimeline().pause();
		this.fruitTimer.cancel();
		this.bombTimer.cancel();
	}

	public void setState() {
		if (score <= GameInfo.getInstance().getEndOfLevelOne())
			gameState = new LevelOneState();
		else if (score <= GameInfo.getInstance().getEndOfLevelTwo())
			gameState =  new LevelTwoState();
		else 
			gameState = new LevelThreeState();
	}


}
