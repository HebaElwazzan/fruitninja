package model;

import javafx.scene.control.Label;

public class LevelObserver implements Observer{
	
	private Label levelLabel;
	private GameModel gameModel;

	public LevelObserver(Label levelLabel, GameModel gameModel) {
		super();
		this.levelLabel = levelLabel;
		this.gameModel = gameModel;
	}

	public Label getLevelLabel() {
		return levelLabel;
	}

	public void setLevelLabel(Label levelLabel) {
		this.levelLabel = levelLabel;
	}

	@Override
	public void update(GameScreenLabel gameScreenLabel) {
		levelLabel.setText(gameScreenLabel.getLevelLabel());
		if (!(gameModel.getState() instanceof ArcadeGameState))
			gameModel.setState();
	}

}
