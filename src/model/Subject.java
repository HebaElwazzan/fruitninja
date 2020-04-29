package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	private List<Observer> observers = new ArrayList<>();
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	public void notifyAllObservers(GameScreenLabel gameScreenLabel) {
		for (Observer observer: observers) {
			observer.update(gameScreenLabel);
		}
	}

}
