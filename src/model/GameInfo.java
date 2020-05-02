package model;

import javax.xml.bind.JAXBException;
import controller.XMLFileHandler;
import controller.XmlGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class GameInfo {

	private static GameInfo instance;

	private Player currentPlayer = new Player();

	private final int endOfLevelOne = 100;
	private final int endOfLevelTwo = 200;

	private ObservableList<Player> players;

	
	private GameInfo() {
		this.players = FXCollections.observableArrayList();

		try {
			XmlGame xmlGame = XMLFileHandler.LoadFile("GameData.xml");
			this.players = xmlGame.getPlayers();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public int getEndOfLevelOne() {
		return endOfLevelOne;
	}

	public int getEndOfLevelTwo() {
		return endOfLevelTwo;
	}


	public static GameInfo getInstance (){
		if (instance == null)
			instance = new GameInfo();
		return instance;
	}

	public ObservableList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ObservableList<Player> players) {
		this.players = players;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getLevelOneTopPlayer() {
		Player topPlayer = new Player("No highscore\t", 0, 0);
		for(Player player: players) {
			if (player.getClassicHighScore() <= endOfLevelOne) {
				if (player.getClassicHighScore() > topPlayer.getClassicHighScore())
					topPlayer = player;
			}
		}
		return topPlayer;
	}

	public Player getLevelTwoTopPlayer() {
		Player topPlayer = new Player("No highscore\t", 0, 0);
		for(Player player: players) {
			if (player.getClassicHighScore() <= endOfLevelTwo && player.getClassicHighScore() > endOfLevelOne) {
				if (player.getClassicHighScore() > topPlayer.getClassicHighScore())
					topPlayer = player;
			}
		}
		return topPlayer;
	}

	public Player getLevelThreeTopPlayer() {
		Player topPlayer = new Player("No highscore\t", 0, 0);
		for(Player player: players) {
			if (player.getClassicHighScore() > endOfLevelTwo) {
				if (player.getClassicHighScore() > topPlayer.getClassicHighScore())
					topPlayer = player;
			}
		}
		return topPlayer;
	}

	public Player getArcadeModeTopPlayer() {
		Player topPlayer = new Player("No highscore\t", 0, 0);
		for (Player player: players) {
			if (player.getArcadeHighScore() > topPlayer.getArcadeHighScore())
				topPlayer = player;
		}
		return topPlayer;
	}
	

}
