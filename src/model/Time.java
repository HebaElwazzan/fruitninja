package model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Time {

	private int minutes;
	private int seconds;
	private Timeline timeline;
	
	public Time() {
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		minutes = 0;
		seconds = 0;
	}

	public Time(int minutes, int seconds) {
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		this.minutes = minutes;
		this.seconds = seconds;
		
	}
	
	public Timeline getTimeline() {
		return timeline;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void startIncrementTime(GameModel gameModel) {
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),new EventHandler() {
			public void handle(Event event) {
				seconds++;
				if (seconds == 60) {
					seconds = 0;
					minutes++;
				}
				gameModel.notifyAllObservers(
						new GameScreenLabel(gameModel.getState().toString(), 
								gameModel.getTime().toString(), gameModel.getLives(), Integer.toString(gameModel.getScore())));
			}
		}

				));
		timeline.playFromStart();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void startDecrementTime(GameModel gameModel) {
		
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),new EventHandler() {
			public void handle(Event event) {

				if(minutes == 0) {
					seconds--;
				}
				gameModel.notifyAllObservers(
						new GameScreenLabel(gameModel.getState().toString(), 
								gameModel.getTime().toString(), gameModel.getLives(), Integer.toString(gameModel.getScore())));
				if (seconds <= 0) {
					timeline.stop();

				}
			}
		}

				));
		timeline.playFromStart();

	}
	
	
	@Override
	public String toString() {
		return String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
	}

}
