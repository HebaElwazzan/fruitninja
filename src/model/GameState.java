package model;

public abstract class GameState {
	private int score = 0;
	private Time time;
	
	
	public void updateScore(int incrementToScore) {
		score += incrementToScore;
	}
	public abstract void updateTime();
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

}
