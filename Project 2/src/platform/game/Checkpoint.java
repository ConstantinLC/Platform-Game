package platform.game;

import platform.util.*;

/**
 * Actor that updates the respawn position of the player upon contact
 */
public class Checkpoint extends Actor{

	private double size = 1;
	private Vector position;
	
	public Checkpoint(Vector position){
		this.position = position;
	}
	
	@Override
	public int getPriority() {
		return 55;
	}

	@Override
	public Box getBox(){
		return new Box(position, size, size);
	}
	
	@Override
	public void draw(Input input, Output output){
		output.drawSprite(getSprite("portal.activated"), getBox());
	}
	
	@Override
	public void interact(Actor other){
		if(getBox().isColliding(other.getBox())){
			other.hurt(this, Damage.CHECKPOINT, 1.0, position);
		}
	}
}
