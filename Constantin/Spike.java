package platform.game;

import platform.util.*;

/**
 * Spike actor, deals physical damage on contact with an actor that is moving towards it in the right direction	
 */
public class Spike extends Actor{

	private Vector position;
	private double angle;
	
	public Spike(Vector position, double angle){
		if(position == null)
			throw new NullPointerException();
		this.position = position;
		this.angle = angle;
	}
	
	@Override
	public Box getBox(){
		super.getBox();
		return new Box(position.add(new Vector(0,0.25)), 1, 0.5);
	}
	
	@Override
	public int getPriority() {
		return 43;
	}
	
	@Override
	public void interact(Actor other){
		super.interact(other);
		if (angle == 0)
			if (getBox().isColliding(other.getBox()) && other.getVelocity().getY() < -1)
				other.hurt(this , Damage.PHYSICAL, 0.1, getPosition());
		if (angle == Math.PI/2)
			if (getBox().isColliding(other.getBox()) && other.getVelocity().getX() > 1)
				other.hurt(this , Damage.PHYSICAL, 0.1, getPosition());
		if (angle == Math.PI)
			if (getBox().isColliding(other.getBox()) && other.getVelocity().getY() > 1)
				other.hurt(this , Damage.PHYSICAL, 0.1, getPosition());
		if (angle == 3*Math.PI/2)
			if (getBox().isColliding(other.getBox()) && other.getVelocity().getX() < -1)
				other.hurt(this , Damage.PHYSICAL, 0.1, getPosition());

	}
	
	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		output.drawSprite(getSprite("spikes"), getBox(), angle);
	}
	
}
