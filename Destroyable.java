package platform.game;
import platform.util.*;

public class Destroyable extends Actor{

	Vector position;
	double width;
	double height;
	boolean explosed = false;
	double time = 0.3;
	private Particle particle;

	public Destroyable(Vector position, double width, double height, Particle particle){
		this.height = height;
		this.position = position;
		this.width = width;
		this.particle = particle;
	}

	public int getPriority(){
		return 25;
	}

	public Box getBox(){
		return new Box(position, width, height);
	}

	public boolean isSolid(){
		return true;
	}

	public void update(Input input){
		super.update(input);
		if (explosed){
			getWorld().register(particle);
			getWorld().unregister(this);
		}
	}


	@Override 
	public boolean hurt(Actor instigator, Damage type, double amount, Vector location) {
		super.hurt(instigator, type, amount, location);
		switch (type) {
		case FIRE:
			explosed = true;
			return true;
		default : 
			return super.hurt(instigator, type, amount, location); 
		} 
	}

	public void draw(Input input, Output output){
		super.draw(input, output);
		if (!explosed){
			String name = "box.single"; 
			output.drawSprite(getSprite(name), getBox());
		}
	}
}
