package platform.game;

import platform.util.*;

/**
 * Actor that deals infinite void damage to actors that leave its box
 */
public class Limits extends Actor{

	private Box rectangle;

	public Limits(Box box){
		rectangle = box;
	}

	@Override
	public int getPriority() {
		return 1000;
	}

	@Override
	public Box getBox() {
		return rectangle;
	}

	@Override
	public void interact(Actor other) {
		if (!getBox().isColliding(other.getBox())) {
			if (other.hurt(this , Damage.VOID, Double.POSITIVE_INFINITY, Vector.ZERO)){
			}
		}

	}
}
