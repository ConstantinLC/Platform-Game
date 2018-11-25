package platform.game;
import platform.game.Actor.Damage;
import platform.util.*;

/**
 * actor that deals continuous fire damage on contact
 */
public class Lava extends Actor{

	private Vector position;
	private double SIZE = 1;
	
	public Lava(Vector position){
		this.position = position;
	}
	
	@Override
	public int getPriority(){
		return 1000;
	}
	
	@Override
	public Box getBox(){
		return new Box(position, SIZE, SIZE);
	}
	
	@Override
	public void interact(Actor other) {
		if (getBox().isColliding(other.getBox())) {
			if (other.hurt(this , Damage.FIRE, 1.0, getPosition()));
		}
		super.interact(other) ;
	}

	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		output.drawSprite(getSprite("rpgTile029"), getBox());
	}
}
