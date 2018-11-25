package platform.game;

import platform.util.*;

/**
 * Projectile that does fire damage
 */
public class Fireball extends Projectile{

	static private double SIZE = 0.4;
	private double lifeTime;

	public Fireball(Vector position, Vector velocity, Actor owner, double lifeTime){
		super(position, velocity, SIZE, SIZE, owner, 1, 1);
		if(position == null || velocity == null)
			throw new NullPointerException();
		this.lifeTime = lifeTime;
	} 

	@Override
	public void update(Input input){
		super.update(input);
		lifeTime -= input.getDeltaTime();
		if(lifeTime < 0){
			getWorld().unregister(this);
		}
	}

	@Override
	public void draw(Input input , Output output) {
		if(getBox() != null)
			output.drawSprite(getSprite("fireball"), getBox(), input.getTime());
		super.draw(input, output);
	}

	@Override
	public void interact(Actor other) {
		if (getBox().isColliding(other.getBox())) {
			if(other != super.getOwner())
				if (other.hurt(this , Damage.FIRE, 1.0, getPosition())){
					getWorld().unregister(this);
				}
		}
		super.interact(other) ;
	} 
}