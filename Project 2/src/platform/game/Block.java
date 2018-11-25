package platform.game;

import platform.util.*;

/**
 * Simple solid actor that does nothing.
 */
public class Block extends Actor {

	private Box rectangle;
	private Sprite sprite;
	private int repetitions;
	private String repetitionDirection;

	public Block(Box rectangle, Sprite sprite){
		this.rectangle = rectangle;
		this.sprite = sprite;
		this.repetitions = 1;
		this.repetitionDirection = "X";
	}

	public Block(Box rectangle, Sprite sprite, int repetitions, String repetitionDirection){
		this(rectangle, sprite);
		this.repetitions = repetitions;
		this.repetitionDirection = repetitionDirection;
	}

	@Override
	public boolean isSolid() {
		return true ;
	}
	
	public Sprite getSprite(){
		return sprite;
	}

	@Override
	public Box getBox() {
		return rectangle ;
	}
	
	public Box getDeltaBox(Vector position){
		return rectangle.add(position.sub(rectangle.getCenter()));
	}

	@Override
	public int getPriority() {
		return 0;
	}

	/**
	 * Repeats a texture in it's box
	 */
	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);
		if(getBox() != null){
			Box box = getBox().scale(1/(double)repetitions, repetitionDirection);
			for(int i = 0; i < repetitions; ++i)
				output.drawSprite(getSprite(), repetitionDirection.equals("Y") ? box.add(new Vector(0,i)):box.add(new Vector(i,0)));
		}
	}
}
