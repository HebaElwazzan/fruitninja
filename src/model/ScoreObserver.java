package model;

import javafx.scene.control.Label;

public class ScoreObserver implements Observer{
	
	private Label scoreLabel;

	public ScoreObserver(Label scoreLabel) {
		super();
		this.scoreLabel = scoreLabel;
	}

	public Label getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(Label scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	@Override
	public void update(GameScreenLabel gameScreenLabel) {
		scoreLabel.setText(gameScreenLabel.getScoreLabel());
	}

}
