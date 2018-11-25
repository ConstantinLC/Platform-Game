package platform.game;

import platform.util.*;

/**
 * Mover with the funtionaility of a spike
 */
public class SpikeMover extends Mover{

	private double angle;
	public static double UP = 0;
	private static double LEFT = Math.PI/2;
	private double DOWN = Math.PI;
	private double RIGHT = 3*Math.PI/2;
	private double cooldown = 0.5;
	private double timer = cooldown;

	public SpikeMover(Vector position, double angle, Signal signal, Vector off, Vector on, double travelTime){
		super(new Box(position.add(new Vector(0, 0.25)), 1, 0.5), null, signal, off, on, travelTime);
		if (angle != UP && angle != LEFT && angle!= DOWN && angle!= RIGHT){
			throw new IllegalArgumentException();
		}
		this.angle = angle;
	}

	public void update(Input input){
		super.update(input);
		timer -= input.getDeltaTime();
	}

	@Override
	public Box getBox(){
		return super.getBox();
	}

	@Override
	public int getPriority() {
		return 50;
	}

	@Override
	public void interact(Actor other){
		super.interact(other);
		if (getBox().isColliding(other.getBox()) && timer <= 0){
			if (angle == UP)
				if (other.getVelocity().getY() < -1)
					if (other.hurt(this , Damage.PHYSICAL, 2, getPosition()))
						timer = cooldown;
			if (angle == LEFT)
				if (other.getVelocity().getX() > 1)
					if (other.hurt(this , Damage.PHYSICAL, 2, getPosition()))
						timer = cooldown;
			if (angle == DOWN)
				if (other.getVelocity().getY() > 1)
					if (other.hurt(this , Damage.PHYSICAL, 2, getPosition()))
						timer = cooldown;
			if (angle == RIGHT)
				if (other.getVelocity().getX() < -1)
					if (other.hurt(this , Damage.PHYSICAL, 2, getPosition()))
						timer = cooldown;
		}
	}

	@Override
	public void draw(Input input , Output output) {
		output.drawSprite(getSprite("spikes"), getBox(), angle);
	}

}


