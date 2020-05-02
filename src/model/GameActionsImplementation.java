package model;

import javax.xml.bind.JAXBException;

import controller.ButtonHandler;

/*
 * this class was not used
 */
public class GameActionsImplementation implements GameActions{

	@Override
	public GameObject createGameObject() {
		return null;
	}

	@Override
	public void updateObjectsLocations() {
		
	}

	@Override
	public void sliceObjects() {
		
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
