package platform.game;

import platform.game.level.Level;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Actor that loads a new level upon contact with the player according to a signal
 */
public class Exit extends Actor{

	private Vector position;
	private Level level;
	private Signal signal;
	
	public Exit(Vector position, Level level, Signal signal){
		this.position = position;
		this.level = level;
		this.signal = signal;
	}
	
	@Override
	public Box getBox(){
		super.getBox();
		return new Box(position, 1, 1);
	}
	
	@Override
	public int getPriority() {
		return 40;
	}

	@Override
	public void draw(Input input , Output output) {
		if(signal.isActive())
			output.drawSprite(getSprite("door.open"), getBox());
		else
			output.drawSprite(getSprite("door.closed"), getBox());
	}
	
	@Override
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
			case ACTIVATION :
				if(signal.isActive()){
					getWorld().setNextLevel(level);
					getWorld().nextLevel();
				}
				return signal.isActive();
			default :
				return super.hurt(instigator , type, amount , location) ;
		}
	}
}
