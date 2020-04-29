package model;

import javafx.scene.control.Label;

public class TimerObserver implements Observer{
	
	private Label timerLabel;

	public TimerObserver(Label timerLabel) {
		super();
		this.timerLabel = timerLabel;
	}

	public Label gettimerLabel() {
		return timerLabel;
	}

	public void settimerLabel(Label timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public void update(GameScreenLabel gameScreenLabel) {
		timerLabel.setText(gameScreenLabel.getTimeLabel());
	}

}
