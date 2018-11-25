package platform.game;
import platform.util.*;

/**
 * Generates fireball at an interval and a position
 */
public class FireballGenerator extends Actor{

	private Vector position;
	private double timer;
	private double time;
	
	public FireballGenerator(Vector position, double timer){
		this.position = position;
		this.timer = timer;
	}
	
	@Override
	public int getPriority(){
		return 100;
	}
	
	@Override
	public void update(Input input){
		time += input.getDeltaTime();
		if (time > timer){
			time = 0;
			getWorld().register(new Fireball(position.add(new Vector(0,2)), new Vector(4, 8), this, 2));
		}
	}
}
