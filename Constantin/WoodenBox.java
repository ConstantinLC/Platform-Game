package platform.game;
import platform.util.*;

/**
 * Base class of all simulated actors, attached to a world.
 */
public class WoodenBox extends Actor{

	Vector position;
	double size;
	double time = 0.3;

	public WoodenBox(Vector position, double size){
		this.position = position;
		this.size = size;
	}

	@Override
	public int getPriority(){
		return 13;
	}

	@Override
	public Box getBox(){
		return new Box(position, size, size);
	}

	@Override
	public boolean isSolid(){
		return true;
	}

	@Override 
	public boolean hurt(Actor instigator, Damage type, double amount, Vector location) {
		switch (type) {
		case FIRE:
			if(amount > 2){
				getWorld().register(new Particle(getPosition(), size, 0.6, "smokes/smoke.", 10));
				getWorld().unregister(this);
				return true;
			}
			return false;
		default : 
			return super.hurt(instigator, type, amount, location); 
		}
	}

	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		output.drawSprite(getSprite("box.single"), getBox());
	}
}
