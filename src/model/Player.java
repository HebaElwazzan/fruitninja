package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Player")
public class Player {
	
	@XmlElement(name = "name")
	private String name;
	
	@XmlElement(name = "classicHighScore")
	private int classicHighScore = 0;
	
	@XmlElement(name = "arcadeHighScore")
	private int arcadeHighScore = 0;
	
	public Player() {
		
	}
	
	public Player(String name, int classicHighScore, int arcadeHighScore) {
		super();
		this.name = name;
		this.classicHighScore = classicHighScore;
		this.arcadeHighScore = arcadeHighScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassicHighScore() {
		return classicHighScore;
	}

	public void setClassicHighScore(int classicHighScore) {
		this.classicHighScore = classicHighScore;
	}

	public int getArcadeHighScore() {
		return arcadeHighScore;
	}

	public void setArcadeHighScore(int arcadeHighScore) {
		this.arcadeHighScore = arcadeHighScore;
	}

	@Override
	public String toString() {
		return name;
	}
}
