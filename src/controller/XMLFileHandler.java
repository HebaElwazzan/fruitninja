package controller;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Game;


public class XMLFileHandler {

	public static XmlGame LoadFile(String filename) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(XmlGame.class);

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		return (XmlGame) unmarshaller.unmarshal(new File(filename));

	}

	public static void saveFile(String filename) throws JAXBException {
		
		XmlGame xmlGame = new XmlGame();
		xmlGame.setPlayers(Game.getInstance().getPlayers());

		JAXBContext jaxbContext = JAXBContext.newInstance(XmlGame.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(xmlGame, new File(filename));

	}
}
