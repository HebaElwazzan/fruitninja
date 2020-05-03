package model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import loader.ResourceLoader;
import model.GameInfo;


public class XMLFileHandler {

	public static XmlGame LoadFile(String filename) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(XmlGame.class);

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		return (XmlGame) unmarshaller.unmarshal(ResourceLoader.load(filename));

	}

	public static void saveFile(String filename) throws JAXBException {
		
		XmlGame xmlGame = new XmlGame();
		xmlGame.setPlayers(GameInfo.getInstance().getPlayers());

		JAXBContext jaxbContext = JAXBContext.newInstance(XmlGame.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(xmlGame, (Result) ResourceLoader.load(filename));

	}
}
