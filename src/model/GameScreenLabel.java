package model;

public class GameScreenLabel {
	private String levelLabel;
	private String timeLabel;
	private int numbeOfLives;
	private String scoreLabel;
	public GameScreenLabel(String levelLabel, String timeLabel, int numberOfLives, String scoreLabel) {
		super();
		this.levelLabel = levelLabel;
		this.timeLabel = timeLabel;
		this.numbeOfLives = numberOfLives;
		this.scoreLabel = scoreLabel;
	}
	public String getLevelLabel() {
		return levelLabel;
	}
	public void setLevelLabel(String levelLabel) {
		this.levelLabel = levelLabel;
	}
	public String getTimeLabel() {
		return timeLabel;
	}
	public void setTimeLabel(String timeLabel) {
		this.timeLabel = timeLabel;
	}
	public int getNumbeOfLives() {
		return numbeOfLives;
	}
	public void setNumbeOfLives(int numbeOfLives) {
		this.numbeOfLives = numbeOfLives;
	}
	public String getScoreLabel() {
		return scoreLabel;
	}
	public void setScoreLabel(String scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	
}
