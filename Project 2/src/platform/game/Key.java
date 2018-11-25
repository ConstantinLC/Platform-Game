package platform.game;

import platform.util.*;

/**
 * Signal that is on when collected
 */
public class Key extends Actor implements Signal{
	
	public final static String BLUE = "blue";
	public final static String GREEN = "green";
	public final static String RED = "red";
	public final static String YELLOW = "yellow";	
	
	private Vector position;
	private boolean taken;
	private String colour;

	public Key(Vector position, String colour){
		if(position == null)
			throw new NullPointerException();
		if(!(colour.equals(BLUE) || colour.equals(GREEN) || colour.equals(RED) || colour.equals(YELLOW)))
			throw new IllegalArgumentException();
		this.position = position;
		taken = false;
		this.colour = colour;
	}
	
	@Override
	public int getPriority() {
		return 44;
	}

	@Override
	public boolean isActive() {
		return taken;
	}
	
	@Override
	public Box getBox() {
		super.getBox();
		return new Box(position, 1, 1);
	}
	
	@Override
	public void interact(Actor other){
		super.interact(other);
		if(getBox().isColliding(other.getBox()))
			if(other.hurt(this, Damage.ACTIVATION, 1, getPosition())){
				taken = true;
				unregister();
			}
	}
	
	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		if(getWorld() != null)
			output.drawSprite(getSprite("key."+colour), getBox());
	}
	
}
