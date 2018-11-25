package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Signal that can turned on and off through activation damage, switches to its off state aftr a delay
 */
public class Lever extends Actor implements Signal{

	private boolean value;
	private Box box;
	private double duration;
	private double time;
	
	public Lever(Box box){
		this.box = box;
		value = false;
		duration = Double.POSITIVE_INFINITY;
	}
	
	public Lever(Box box, double duration){
		this.box = box;
		value = false;
		this.duration = duration;
	}
	
	@Override
	public boolean isActive() {
		return value;
	}

	@Override
	public int getPriority() {
		return 41;
	}

	@Override
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		super.hurt(instigator, type, amount, location);
		switch (type) {
			case ACTIVATION :
				if(amount > 0){
					value = !value;
					if(value){
						time = duration;
					}
				}
			default :
				return super.hurt(instigator , type, amount , location) ;
		}
		
		
	}
	
	@Override
	public void update(Input input) {
		if(time > 0){
			time -= input.getDeltaTime();
		} else if(value){
			value = !value;
		}
	}
	
	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		if(box != null){
			if(value)
				output.drawSprite(getSprite("lever.right"), box);
			else
				output.drawSprite(getSprite("lever.left"), box);
				
		}
	}
	
	@Override
	public Box getBox() {
		return box ;
	}
}
