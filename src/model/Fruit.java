package model;

import java.io.File;
import java.util.Random;

import javafx.animation.ParallelTransition;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public abstract class Fruit extends GameObjectImplementation {
	
	public static String path = System.getProperty("user.dir") + "/resources/sound/Clean-Slice-1.wav";
	public static Media media = new Media(new File(path).toURI().toString());
	public static MediaPlayer mediaPlayer = new MediaPlayer(media);

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
		mediaPlayer.play();
	}






}
