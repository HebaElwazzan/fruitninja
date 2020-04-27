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

	@Override
	public void ResetGame() {
		/*
		 * to reset to initial state we only need to reload xml file and delete any changes that may have occurred since the
		 * beginning of the game session. A memento design pattern will not be necessary in this case.
		 */
		loadGame();
	}

}
