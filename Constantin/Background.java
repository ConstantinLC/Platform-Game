package platform.game;
import platform.util.*;
import platform.util.*;

/**
 * Creates an image of a certain size at location
 */
public class Background extends Actor{

	private Vector position = new Vector(0,0);
	private double width;
	private double height;
	private String name;
	
	public Background(Vector position, double width, double height, String name){
		this.width = width;
		this.height = height;
		this.name = name;
		this.position = position;
	}
	
	@Override
	public int getPriority(){
		return -11;
	}
	
	@Override
	public Box getBox(){
		return new Box(position, width, height);
	}
	
	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		output.drawSprite(getSprite(name), getBox());
	}
}
