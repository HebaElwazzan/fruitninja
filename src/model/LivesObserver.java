package model;

import javafx.scene.image.ImageView;

public class LivesObserver implements Observer{
	
	private ImageView[] lives;

	

	public LivesObserver(ImageView[] lives) {
		super();
		this.lives = lives;
	}
	
	public ImageView[] getLives() {
		return lives;
	}

	public void setLives(ImageView[] lives) {
		this.lives = lives;
	}

	@Override
	public void update(GameScreenLabel gameScreenLabel) {
		if (gameScreenLabel.getNumbeOfLives() == 2) {
			lives[0].setDisable(true);
		}
		if (gameScreenLabel.getNumbeOfLives() == 1) {
			lives[1].setDisable(true);
		}
		if (gameScreenLabel.getNumbeOfLives() == 0) {
			lives[2].setDisable(true);
			//ButtonHandler.gameOverScreen();
		}
		
	}

}
