package platform.game;

import platform.util.*;

/**
 * Teleports an actor to a location on activation
 */
public class Portal extends Actor{

	private Vector position;
	private double size;
	private double timer;
	private double cooldown;
	private Vector destination;
	
	public Portal(Vector position, Vector destination, double size, double cooldown){
		this.position = position;
		this.destination = destination;
		this.size = size;
		this.cooldown = cooldown;
		this.timer = 0.0;
	}
	
	public Vector getDestination(){
		return destination;
	}
	
	@Override
	public Box getBox(){
		return new Box(position, size, size);
	}
	
	@Override
	public int getPriority(){
		return 1;
	}
	
	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		output.drawSprite(getSprite("portal.blue"), getBox(), input.getTime());
	}
	
	@Override
	public void update(Input input) {
		timer -= input.getDeltaTime();
	}
	
	@Override
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
			case ACTIVATION :
				if(timer < 0 && instigator.getClass() == Player.class && new Box(position, size, size).isColliding(location)){
					timer = cooldown;
					instigator.hurt(this, Damage.TELEPORTATION, 1.0, destination);
					return true;
				}
				return false;
			default :
				return super.hurt(instigator , type, amount , location) ;
		}
	}
}



