package platform.game;
import platform.util.*;

/**
 * Actor that produces animations.
 */
public class Particle extends Actor{

	private Vector position;
	private double SIZE;
	private double duration;
	private double time = 0;
	private String filePath;
	private int frames;

	public Particle(Vector position, double SIZE, double duration, String filePath, int frames){
		this.position = position;
		this.SIZE = SIZE;
		this.duration = duration;
		this.filePath = filePath;
		this.frames = frames;
	}

	@Override
	public int getPriority(){
		return 53;
	}
	
	@Override
	public Box getBox(){
		return new Box(position, SIZE, SIZE);
	}

	@Override 
	public void update(Input input) {
		super.update(input);
			time += input.getDeltaTime();
			if (time >= duration) 
				getWorld().unregister(this);
	}

	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		int x = (int) ((Math.floor(time*frames))/duration + 1);
		if (x < frames)
			output.drawSprite(getSprite(filePath + x), getBox());
	}
}
