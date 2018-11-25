package platform.game;

import platform.util.*;

/**
 * A mover that has the functionality of a jumper.
 */
public class JumperMover extends Mover{

	private double cooldown;
	private double angle;

	public JumperMover(Signal signal, Vector off, Vector on, double travelTime, double angle){
		super(new Box(off, 1, 1), null, signal, off, on, travelTime);
		this.angle = angle;
	}

	@Override
	public int getPriority() {
		return 50;
	}

	@Override
	public Box getBox(){
		return super.getBox();
	}

	public boolean isSolid(){
		return false;
	}

	@Override
	public void update(Input input) {
		super.update(input) ;
		cooldown -= input.getDeltaTime() ;
	}
	@Override
	public void interact(Actor other) {
		if (cooldown <= 0 && getBox().isColliding(other.getBox())) {
			Vector below = new Vector(super.getPosition().getX(), super.getPosition().getY() - 1.0) ;
			if (other.hurt(this , Damage.AIR, 10.0, below))
				cooldown = 0.5 ;
		}
	}


	@Override
	public void draw(Input input , Output output) {
		if(cooldown > 0){
			output.drawSprite(getSprite("jumper.extended"), getBox(), angle);
		} else{
			output.drawSprite(getSprite("jumper.normal"), getBox(), angle);
		}
	}
}
