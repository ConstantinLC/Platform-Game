package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Actor that deals air damage on contact
 */
public class Jumper extends Actor{

	private double cooldown;
	private Vector position;;
	
	public Jumper(Vector position){
		this.position = position;
	}
	
	@Override
	public int getPriority() {
		return 100;
	}
	
	@Override
	public Box getBox(){
		return new Box(position, 1, 1);
	}

	@Override
	public void update(Input input) {
		super.update(input) ;
		cooldown -= input.getDeltaTime() ;
	}
	@Override
	public void interact(Actor other) {
		super.interact(other) ;
		if (cooldown <= 0 && getBox().isColliding(other.getBox())) {
			Vector below = new Vector(position.getX(),
			position.getY() - 1.0) ;
			if (other.hurt(this , Damage.AIR, 10.5, below))
				cooldown = 0.5 ;
		}
	}
	
	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		if(cooldown > 0){
			output.drawSprite(getSprite("jumper.extended"), getBox());
		} else{
		output.drawSprite(getSprite("jumper.normal"), getBox());
		}
	}
}
