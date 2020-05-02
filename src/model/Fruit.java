package model;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public abstract class Fruit extends GameObjectImplementation {

	/*
	 * This method sets the score of the fruit sliced. It gets overrided if the fruit is a special one.
	 */
	public int getScoreOnSlicing() {
		return 10;
	}

	/*
	 * This method plays a sound on the fruit getting sliced.
	 */
	@Override
	public void playSound() {
		if (!isSliced()) {
			String path = System.getProperty("user.dir") + "/resources/sound/Clean-Slice-1.wav";
			Media media = new Media(new File(path).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaPlayer.play();
		}
	}

}
