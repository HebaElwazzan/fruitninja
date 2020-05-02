package model;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public abstract class Bomb extends GameObjectImplementation{

	/*
	 * this method plays a sound on the bomb getting detonated 
	 */
	@Override
	public void playSound() {
		if (!isSliced()) {
			String path = System.getProperty("user.dir") + "/resources/sound/Bomb-explode.wav";
			Media media = new Media(new File(path).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaPlayer.play();
		}	
	}


}
