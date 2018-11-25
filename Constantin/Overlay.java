package platform.game;

import platform.util.*;

/**
 * Actor that displays the health of an actor above the actor's position
 */
public class Overlay extends Actor{

	private Living person;
	
	public Overlay(Living person){
		this.person = person;
	}
	
	@Override
	public int getPriority() {
		return 256;
	}

	@Override
	public Box getBox(){
		return ((Actor)person).getBox();
	}
	
	@Override
	public void update(Input input) {
		if(((Actor)person).getWorld() == null){
			getWorld().unregister(this);
		}
	}
	
	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		double health = 5.0 * person.getHealth() /person.getMaxHealth() ;
		for (int i = 1 ; i <= 5 ; ++i) {
			String name ;
			if (health >= i)
				name = "heart.full" ;
			else if (health >= i - 0.5)
				name = "heart.half" ;
			else
				name = "heart.empty" ;
			// trouver le Sprite associé à name
			output.drawSprite(getSprite(name), new Box(((Actor)person).getPosition().add(new Vector(2*i/10.0-0.6, 0.6)), 0.2, 0.2));
		}
	}
	
}
