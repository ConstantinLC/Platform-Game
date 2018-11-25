package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Actor that heals the player and respawns after a timer
 */
public class Heart extends Actor{

	private double cooldown;
	private double counter;
	private Vector position;
	
	public Heart(Vector position, double cooldown){
		this.position = position;
		this.cooldown = cooldown;
		this.counter = 0.0;
	}
	
	@Override
	public void update(Input input) {
		super.update(input);
		if(counter > 0.0){
			counter -= input.getDeltaTime();
		}
	}
	
	@Override
	public Box getBox(){
		super.getBox();
		return new Box(position, 0.4, 0.4);
	}
	
	@Override
	public int getPriority() {
		return 43;
	}
	
	@Override
	public void interact(Actor other){
		super.interact(other);
		if(counter <= 0.0){
			if (getBox().isColliding(other.getBox())) {
				if (other.hurt(this , Damage.HEAL, 1.0, getPosition()))
					counter = cooldown;
			}
		}
	}
	
	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		if(counter <= 0.0)
			output.drawSprite(getSprite("heart.full"), getBox());
	}
	
}
