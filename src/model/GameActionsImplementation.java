package model;

import javax.xml.bind.JAXBException;

import controller.ButtonHandler;
import controller.XMLFileHandler;

public class GameActionsImplementation implements GameActions{

	@Override
	public GameObject createGameObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateObjectsLocations() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sliceObjects() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGame() {
		try {
			XMLFileHandler.saveFile("GameData.xml");
		} catch (JAXBException e) {
			ButtonHandler.alert();
			e.printStackTrace();
		}
	}

	@Override
	public void loadGame() {
		try {
			XMLFileHandler.LoadFile("GameData.xml");
		} catch (JAXBException e) {
			ButtonHandler.alert();
			e.printStackTrace();
		}
	}

	/*
	 * to reset to initial state we only need to load the empty xml 
	 * file. A memento design pattern will not be necessary in this case.
	 */
	@Override
	public void ResetGame() {
		
		try {
			XMLFileHandler.LoadFile("ResetGameData.xml");
		} catch (JAXBException e) {
			ButtonHandler.alert();
			e.printStackTrace();
		}
	}

}
