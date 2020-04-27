package model;

import javax.xml.bind.JAXBException;
import controller.XMLFileHandler;
import controller.XmlGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Game {
	
	private static Game instance;
	
	Player currentPlayer;
	
	private ObservableList<Player> players;

	private Game() {
		this.players = FXCollections.observableArrayList();
	
		try {
			XmlGame xmlGame = XMLFileHandler.LoadFile("GameData.xml");
			this.players = xmlGame.getPlayers();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setInstance(Game game) {
		instance = game;
	}

	public static Game getInstance (){
		if (instance == null)
			instance = new Game();
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
	
	


}
