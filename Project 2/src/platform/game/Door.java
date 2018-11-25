package platform.game;

import platform.util.*;

/**
 * Block that can dissapear according to a signal
 */
public class Door extends Block{

	private Signal signal;
	
	public Door(Box rectangle, Sprite sprite, Signal signal) {
		super(rectangle, sprite);
		this.signal = signal;
	}
	
	@Override
	public boolean isSolid() {
		return !signal.isActive() ;
	}
	
	@Override
	public Box getBox() {
		if(signal.isActive())
			return null;
		return super.getBox() ;
	}
	
	@Override
	public void draw(Input input , Output output) {
		if(getBox() != null && !signal.isActive())
			super.draw(input, output);
	}
}
