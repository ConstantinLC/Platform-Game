package platform.game;
import platform.util.*;

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

	public Particle(Vector position, double SIZE, double duration, double angle){
		this.position = position;
		this.SIZE = SIZE;
		this.duration = duration;
	}

	public int getPriority(){
		return 1337;
	}

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

	public void draw(Input input, Output output){
		super.draw(input, output);
		int x = (int) (Math.floor(time*frames) + 1);
		if (x < frames){
			output.drawSprite(getSprite(filePath + x), getBox());
		}else{
			getWorld().unregister(this);
		}
		System.out.println();
	}

}
