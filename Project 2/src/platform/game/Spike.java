package platform.game;

import platform.util.*;

/**
 * Spike actor, deals physical damage on contact with an actor that is moving towards it in the right direction	
 */
public class Spike extends Actor{

	private Vector position;
	private double angle;
	public static double UP = 0;
	private static double LEFT = Math.PI/2;
	private double DOWN = Math.PI;
	private double RIGHT = 3*Math.PI/2;

	private double cooldown = 0.5;
	private double timer = 0;

	public Spike(Vector position, double angle){
		if(position == null)
			throw new NullPointerException();
		if (angle != UP && angle != LEFT && angle!= DOWN && angle!= RIGHT){
			throw new IllegalArgumentException();
		}
		this.position = position;
		this.angle = angle;
	}
	
	public void update(Input input){
		timer -= input.getDeltaTime();
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
		if (getBox().isColliding(other.getBox()) && timer <= 0){
			if (angle == UP)
				if (other.getVelocity().getY() < -1){
					if (other.hurt(this , Damage.PHYSICAL, 2, getPosition()))
						timer = cooldown;
				}
			if (angle == LEFT)
				if (other.getVelocity().getX() > 1){
					if (other.hurt(this , Damage.PHYSICAL, 2, getPosition()))
						timer = cooldown;
				}
			if (angle == DOWN)
				if (other.getVelocity().getY() > 1){
					if (other.hurt(this , Damage.PHYSICAL, 2, getPosition()))
						timer = cooldown;
				}
			if (angle == RIGHT)
				if (other.getVelocity().getX() < -1){
					if (other.hurt(this , Damage.PHYSICAL, 2, getPosition()))
						timer = cooldown;
				}
		}
	}

	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		output.drawSprite(getSprite("spikes"), getBox(), angle);
	}

}
