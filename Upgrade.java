package platform.game;

import platform.util.*;

public class Upgrade extends Actor{

	private Vector position;
	private double upgrade;
	public static final double FIREBALLUPGRADE = 1.0;
	public static final double DOUBLEJUMPUPGRADE = 2.0;
	public static final double BOMBUPGRADE = 3.0;
	public static final double GRAVITYUPGRADE = 4.0; 
	
	public Upgrade(Vector position, double upgrade){
		this.position = position;
		this.upgrade = upgrade;
	}
	
	@Override
	public int getPriority() {
		return 52;
	}
	
	@Override
	public Box getBox(){
		return new Box(position, 1, 1);
	}
	
	@Override
	public void draw(Input input , Output output) {
		if(getWorld() != null)
			output.drawSprite(getSprite("box.item"), getBox());
		super.draw(input, output);
	}
	
	@Override
	public void interact(Actor other){
		if(getBox().isColliding(other.getBox()))
			if(other.hurt(this, Damage.UPGRADE, upgrade, position))
				this.unregister();
	}
	
}
