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
	
	@Override
	public String toString() {
		return name;
	}
}
