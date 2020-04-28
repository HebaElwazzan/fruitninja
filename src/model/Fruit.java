package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.ButtonHandler;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

public abstract class Fruit implements GameObject {

	/*
	 * This method sets the score of the fruit sliced. It gets overrided if the fruit is a special one.
	 */
	public int getScoreOnSlicing() {
		return 10;
	}

	@Override
	public ObjectType getObjectType() {
		Random random = new Random();
		return ObjectType.values()[random.nextInt(5)];
	}

	@Override
	public int getXlocation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYlocation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInitialVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFallingVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean isSliced() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasMovedOffScreen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void slice() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(double time) {

		try {
			while (!isSliced()) {
				Path path = new Path();
				Random random = new Random();

				int startingPosition = random.nextInt();

				MoveTo moveTo = new MoveTo(); 
				moveTo.setX(startingPosition); 
				moveTo.setY(0); 

				QuadCurveTo quadCurveTo = new QuadCurveTo(); 

				quadCurveTo.setX(startingPosition + random.nextInt(300)); 
				quadCurveTo.setY(0); 
				quadCurveTo.setControlX(startingPosition + quadCurveTo.getX());  
				quadCurveTo.setControlY(random.nextInt(700));      

				path.getElements().add(moveTo); 
				path.getElements().add(quadCurveTo);

				Image image = SwingFXUtils.toFXImage(getBufferedImages()[0], null);
				ImageView imageView = new ImageView();
				imageView.setImage(image);

				PathTransition pathTransition = new PathTransition();
				pathTransition.setNode(imageView);
				
				pathTransition.setDuration(Duration.seconds(time));
				
				RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1));
				rotateTransition.setByAngle(180f);
				
				ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, pathTransition);
				parallelTransition.play();
			} 
			if (isSliced()) {

			}
		} catch (IOException e) {
			ButtonHandler.alert();
			e.printStackTrace();
		}
	}

}
