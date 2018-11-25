package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;
import platform.util.Vector;

public class Mover extends Block{

	private Vector off;
	private Vector on;
	private Signal signal;
	private double current;
	private Vector deltaPosition;
	private double travelTime;

	public Mover(Box rectangle, Sprite sprite, Signal signal, Vector off, Vector on, double travelTime) {
		super(rectangle, sprite);
		this.signal = signal;
		this.off = off;
		this.on = on;
		this.travelTime = travelTime;
	}

	@Override
	public void update(Input input) {
		super.update(input) ;
		Vector prePos = getBox().getCenter();
		if (signal.isActive()) {
			current += input.getDeltaTime()/travelTime;
			if (current > 1.0)
				current = 1.0 ;
		} else {
			current -= input.getDeltaTime()/travelTime;
			if (current < 0.0)
				current = 0.0 ;
		}
		deltaPosition = getBox().getCenter().sub(prePos);
	}

	@Override
	public Box getBox() {
		Vector position = off.add( (on.add(off.opposite())).mul( -2*Math.pow(current, 3) +3*Math.pow(current, 2) ) );
		return super.getBox(position);
	}
	
	@Override
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
			case COLLIDING :
				if(instigator.getClass() == Player.class && getBox().isColliding(instigator.getBox())){
					((Player)instigator).setDeltaPosition(deltaPosition);
					return true;
				}
				return false;
			default :
				return super.hurt(instigator , type, amount , location) ;
		}
	}
}
