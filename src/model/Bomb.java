package model;

import java.io.File;
import java.util.Random;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.GameObject.ObjectType;

public abstract class Bomb extends GameObjectImplementation{
	
	public static String path = System.getProperty("user.dir") + "/resources/sound/Bomb-explode.wav";
	public static Media media = new Media(new File(path).toURI().toString());
	public static MediaPlayer mediaPlayer = new MediaPlayer(media);

	/*
	 * this method plays a sound on the bomb getting detonated 
	 */
	@Override
	public void playSound() {
		mediaPlayer.play();
	}
	

}
