package model;

import java.util.Random;
import model.GameObject.ObjectType;

public abstract class Bomb extends GameObjectImplementation{

	
	@Override
	public ObjectType getObjectType() {
		return null;
		/*Random random = new Random();
		return ObjectType.values()[random.nextBoolean()? 6 : 7];
		*/
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
		// TODO Auto-generated method stub
		
	}

}
