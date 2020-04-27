package controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import model.Player;
/*
 * This class is used to store information from the xml file. 
 * It is then called from the singleton class GameInfo to update the game information.
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "GameInfo")
public class XmlGame {
	
	@XmlElement(name = "Player")
	private ObservableList<Player> players;

	public ObservableList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ObservableList<Player> players) {
		this.players = players;
	}

	public XmlGame() {
		this.players = FXCollections.observableArrayList();
	}
	
	
	

}
