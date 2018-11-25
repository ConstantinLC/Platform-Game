package platform.game;

import platform.util.*;

/**
 * Actor that displays a message at a locaion over the background at a certain position according to a signal
 */
public class Message extends Actor{

	private Vector position;
	private double width;
	private double height = 2.0;
	private int messageNB;
	private Signal signal;
	
	public Message(Vector position, double width, double height, int messageNB, Signal signal){
		this.position = position;
		this.width = width;
		this.height = height;
		this.messageNB = messageNB;
		this.signal = signal;
	}
	
	public int getPriority(){
		return 10;
	}
	
	public Box getBox(){
		return new Box(position, width, height);
	}
	
	public void draw(Input input, Output output){
		super.draw(input, output);
		if (signal.isActive())
			output.drawSprite(getSprite("message." +  messageNB), getBox());
	}
}
