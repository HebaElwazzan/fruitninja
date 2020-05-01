package model;

import java.util.Random;

import model.GameObject.ObjectType;

public class GameObjectFactory {
		
	/*
	 * this method will generate a random integer between 0 and 5 and will be used by getObject to create one of the 
	 * objects from the enum ObjectType.
	 */
	public static ObjectType createRandomFruit() {
		Random random = new Random();
		return ObjectType.values()[random.nextInt(5)];
		
	}
	
	public static ObjectType createRandomBomb() {
		Random random = new Random();
		return ObjectType.values()[random.nextBoolean()? 6 : 7];
	}
	
	public static GameObject getObject(ObjectType objectType) {
		switch(objectType) {
		
		case APPLE:
			return new Apple();
		case BANANA:
			return new Banana();
		case WATERMELON:
			return new Watermelon();
		case SPECIAL_APPLE:
			return new SpecialFruit(new Apple());
		case SPECIAL_BANANA:
			return new SpecialFruit(new Banana());
		case SPECIAL_WATERMELON:
			return new SpecialFruit(new Watermelon());
		case DANGEROUS_BOMB:
			return new DangerousBomb();
		case FATAL_BOMB:
			return new FatalBomb();
		default:
			return null;
		
		}
		
	}

}
