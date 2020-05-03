package model;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public abstract class ClassicGameState implements GameState{
	@Override
	public void updateTime(Time time, GameModel gameModel) {

		time.startIncrementTime(gameModel);		    

	}
	@Override
	public int updateLives(int livesDecrement, int lives) {
		lives = lives - livesDecrement;
		playSound();
		return lives;

	}
	
	public void playSound() {
		String path = System.getProperty("user.dir") + "/resources/sound/Wrong-answer-sound-effect.mp3";
		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}

}
