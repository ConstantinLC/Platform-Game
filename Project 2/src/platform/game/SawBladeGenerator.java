package platform.game;
import platform.util.*;

/**
 * Generates SawBlades at an interval with a position and an intial angle
 */
public class SawBladeGenerator extends Actor{

	private Vector position;
	private Actor target;
	private double timer;
	private double time = 0;
	private double SIZE = 1;
	private double distance;
	
	public SawBladeGenerator(Vector position, Actor target, double timer, double distance){
		this.position = position;
		this.target = target;
		this.timer = timer;
		this.distance = distance;
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
	public void update(Input input){
		time += input.getDeltaTime();
		if (time > timer){
			if (position.sub(target.getPosition()).getLength() < distance)
				getWorld().register(new BladeSaw(position, 1, this, target, Math.PI/2));
				time = 0;
		}
	}

	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		output.drawSprite(getSprite("box.warning.dark"), getBox());
	}
}
