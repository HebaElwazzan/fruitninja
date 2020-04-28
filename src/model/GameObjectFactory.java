package model;

import model.GameObject.ObjectType;

public class GameObjectFactory {
	
	public GameObject getObject(ObjectType objectType) {
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
