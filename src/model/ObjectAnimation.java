package model;

import java.io.IOException;
import java.util.Random;

import controller.ButtonHandler;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

public class ObjectAnimation {
	private Path path;
	private Random random;
	private int startingPosition;
	private Image image;
	private ImageView imageView;
	private PathTransition pathTransition;
	private MoveTo moveTo;
	private QuadCurveTo quadCurveTo;
	private ParallelTransition parallelTransition;
	private double rate;
	private GameObject gameObject;
	private boolean isSliced = false;
	
	public ObjectAnimation(GameObject gameObject){
		
		this.gameObject = gameObject;
		
		path = new Path();
		random = new Random();
		startingPosition = random.nextInt(1100);
		try {
			image = SwingFXUtils.toFXImage(gameObject.getBufferedImages()[0], null);
		} catch (IOException e) {
			ButtonHandler.alert();
			e.printStackTrace();
		}
		imageView = new ImageView();
		pathTransition = new PathTransition();
		moveTo = new MoveTo(); 
		quadCurveTo = new QuadCurveTo();
		
		
		moveTo.setX(startingPosition); 
		moveTo.setY(0); 
 

		quadCurveTo.setX(startingPosition + random.nextInt(300)); 
		quadCurveTo.setY(-20); 
		quadCurveTo.setControlX((startingPosition + quadCurveTo.getX())/2);  
		quadCurveTo.setControlY(700);      

		path.getElements().add(moveTo); 
		path.getElements().add(quadCurveTo);


		imageView.setImage(image);
		imageView.setOnMouseDragOver(new MouseDragHandler());


		pathTransition.setNode(imageView);

		pathTransition.setRate(rate);
		//pathTransition.setDuration(Duration.seconds(timeOfAnimation));
		
		RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1));
		rotateTransition.setByAngle(360f);
		rotateTransition.setCycleCount(Animation.INDEFINITE);
		
		parallelTransition = new ParallelTransition(rotateTransition, pathTransition);
	}
	
	public void setGameObject(GameObject gameObject) {
		this.gameObject = gameObject;
	}

	public ParallelTransition getParallelTransition() {
		return parallelTransition;
	}
	
	public void setAnimationVelocity(double rate) {
		this.rate = rate;
	}
	
	public boolean isSliced() {
		return isSliced;
	}
	
	
	 private class MouseDragHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			try {
				image = SwingFXUtils.toFXImage(gameObject.getBufferedImages()[1], null);
				isSliced = true;
			} catch (IOException e) {
				ButtonHandler.alert();
				e.printStackTrace();
			}			
		}
		 
	 }
}
