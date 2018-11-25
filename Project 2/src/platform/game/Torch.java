package platform.game;

import platform.util.*;

/**
 * Torch actor, can be lit or not and may act as a signal
 */
public class Torch extends Actor implements Signal{

	private Vector position;
	private boolean lit;
	private double variation;
	
	public Torch(Vector position, boolean lit){
		if(position == null)
			throw new NullPointerException();
		this.position = position;
		this.lit = lit;
		variation = 0.0;
	}
	
	@Override
	public int getPriority() {
		return 34;
	}
	
	@Override
	public Box getBox(){
		super.getBox();
		return new Box(position, 0.8, 0.8);
	}	

	@Override
	public void update(Input input){
		variation -= input.getDeltaTime() ;
		if (variation < 0.0)
			variation = 0.6 ;
	}
	
	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		if(!lit)
			output.drawSprite(getSprite("torch"), getBox());
		else if(lit){
			String name = "torch.lit.1" ;
			if (variation < 0.3)
				name = "torch.lit.2" ;
			output.drawSprite(getSprite(name), getBox());
		}
	}
	
	@Override
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		super.hurt(instigator, type, amount, location);
		switch (type) {
			case FIRE :
				lit = true;
				return false;
			case AIR :
				lit = false;
				return false;
			default :
				return super.hurt(instigator , type, amount , location) ;
		}
	}

	@Override
	public boolean isActive() {
		return lit;
	}
	
}
