package model;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
	
	private int minutes;
	private int seconds;
	private Timer timer;
	private TimerTask task;
	DecimalFormat decimalFormat;
	
	public Time() {
		decimalFormat = new DecimalFormat("##");
		minutes = 0;
		seconds = 0;
	}
	
	public Time(int minutes, int seconds) {
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public void startIncrementTime() {
		task = new TimerTask() {
			public void run() {
				seconds++;
				if (seconds == 60) {
					seconds = 0;
					minutes++;
				}
			}
		};
		timer.scheduleAtFixedRate(task, 1000, 1000);
		
	}
	
	public void startDecrementTime() {
		task = new TimerTask() {
			public void run() {
				seconds--;
				if (seconds == 60) {
					seconds = 0;
					minutes--;
				}
			}
		};
		timer.scheduleAtFixedRate(task, 1000, 1000);
	}
	
	@Override
	public String toString() {
		return decimalFormat.format(minutes) + ":" + decimalFormat.format(seconds);
	}

}
