package model;

import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import java.io.IOException;
import java.util.Random;

import controller.ButtonHandler;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

/*
 * Most of the methods' functionality from the GameObject interface were already implemented in ObjectAnimation
 * so some of the methods here simply call on the methods there or are simply useless
 */
public abstract class GameObjectImplementation implements GameObject{

	private boolean isSliced;
	private ImageView imageView;
	ParallelTransition parallelTransition;
	boolean hasMovedOffScreen = false;
	

	public GameObjectImplementation() {
		super();
		isSliced = false;
		parallelTransition = new ParallelTransition();
	}


	@Override
	public ObjectType getObjectType() {
		if (this instanceof Apple) 
			return ObjectType.APPLE;
		else if (this instanceof Banana)
			return ObjectType.BANANA;
		else if (this instanceof Watermelon)
			return ObjectType.WATERMELON;
		else if (this instanceof DangerousBomb) 
			return ObjectType.DANGEROUS_BOMB;
		else if (this instanceof FatalBomb)
			return ObjectType.FATAL_BOMB;
		else return null;
	}


	/*
	 * this method returns an ImageView that can be added to the game screen's root.
	 */
	public ImageView getImageView() {
		return imageView;
	}
	
	public void setImageView() {
		imageView = createNode();
	}
	
	/*
	 * returns parallelTransition for object to be paused or played
	 */
	public ParallelTransition getParallelTransition() {
		return parallelTransition;
	}

	@Override
	public int getXlocation() {
		return (int) imageView.getX();
	}

	@Override
	public int getYlocation() {
		return (int) imageView.getY();
	}

	@Override
	public int getMaxHeight() {
		return 0;
	}

	@Override
	public int getInitialVelocity() {
		return 0;
	}

	//the velocities are decided according to game state
	
	@Override
	public int getFallingVelocity() {
		return 0;
	}

	@Override
	public Boolean isSliced() {
		return isSliced;
	}
	
	/*
	 * This method sets the objects sliced status. The method is called inside the mouse event handler.
	 * The sliced status is used to check for updating score and for updating lives in classic (if not sliced 
	 * and missed, the player loses a life)
	 */

	@Override
	public void setSliced(boolean sliced) {
		this.isSliced = sliced;
	}

	/*
	 * This method is used for setting the hasMovedOffcreen property to the object. It is used 
	 * in the setOnFinish handler for the animation.
	 */
	public void setHasMovedOffScreen(boolean hasMovedOffScreen) {
		this.hasMovedOffScreen = hasMovedOffScreen;
	}
	
	@Override
	public Boolean hasMovedOffScreen() {
		return hasMovedOffScreen;
	}

	@Override
	public void slice() {
		try {
			Image image = SwingFXUtils.toFXImage(this.getBufferedImages()[1], null);
			imageView.setImage(image);
			this.playSound();
		} catch (IOException e) {
			ButtonHandler.alert();
			e.printStackTrace();
		}
		this.setSliced(true);
	}

	/*
	 * This method gets overrided in both bomb and fruit classes so that each may play a distinct sound upon slicing
	 */
	public abstract void playSound();

	@Override
	public void move(double velocity) { 

		Path path = new Path();
		Random random = new Random();
		int startingPosition = random.nextInt(1100);
		PathTransition pathTransition = new PathTransition();
		MoveTo moveTo = new MoveTo(); 
		QuadCurveTo quadCurveTo = new QuadCurveTo();
		moveTo.setX(startingPosition); 
		moveTo.setY(1000); 


		quadCurveTo.setX(startingPosition + random.nextInt(300)); 
		quadCurveTo.setY(975); 
		quadCurveTo.setControlX((startingPosition + quadCurveTo.getX())/2);  
		quadCurveTo.setControlY(-700);      

		path.getElements().add(moveTo); 
		path.getElements().add(quadCurveTo);

		pathTransition.setNode(this.imageView);
		pathTransition.setPath(path);
		pathTransition.setRate(velocity);
		pathTransition.setDuration(Duration.millis(10000));

		RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), this.imageView);
		rotateTransition.setByAngle(360f);
		rotateTransition.setCycleCount(10);

		parallelTransition = new ParallelTransition(rotateTransition, pathTransition);
		parallelTransition.play();
		pathTransition.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				setHasMovedOffScreen(true);
			}
		});
	
	}

	/*
	 * method that creates a node out of a game object so that we can add it to the game screen
	 */
	public ImageView createNode() {
		Image image;
		ImageView newImage = new ImageView();
		try {
			image = SwingFXUtils.toFXImage(this.getBufferedImages()[0], null);
			newImage.setImage(image);
			newImage.setOnMouseDragOver(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					slice();
				}
			});
		} catch (IOException e) {
			ButtonHandler.alert();
			e.printStackTrace();
		}
		
		return newImage;
	}
}



