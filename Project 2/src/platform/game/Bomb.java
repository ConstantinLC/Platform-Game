package platform.game;
import platform.util.*;

/**
 * Projectile that will explode after a delay causing damage in an area.
 */
public class Bomb extends Projectile{

	private double time = 0;
	private double airDamage = 5.0;
	private double fireDamage = 2.5;
	private boolean black = true;
	private double radius = 5;
	private static double SIZE = 0.8;
	private double timer = 4;
	private double color;
	private static double explosionDuration = 0.5;
	
	public Bomb(Vector position, Vector velocity, Actor owner, double friction, double elasticCoeficient){
		super(position, velocity, SIZE, SIZE, owner, friction, elasticCoeficient, true);
	}
	
	/** 
	 * @return the box in which the explosion occurs
	 */
	public Box getExplodingBox(){
		return new Box(super.getPosition(), radius, radius);
	}

	@Override 
	public void update(Input input) {
		super.update(input); 
		time += input.getDeltaTime();
		if (time > timer){
			getWorld().hurt(getExplodingBox(), this, Damage.FIRE, fireDamage, super.getPosition());
			getWorld().hurt(getExplodingBox(), this, Damage.AIR, airDamage, super.getPosition());
			getWorld().register(new Animation(getPosition(), radius, explosionDuration, "explosions/explosion.", 24));
			getWorld().unregister(this);
		}
		
		color = Math.sin(time/0.1*Math.sqrt(time));
		if (color > 0){
			black = true;
		}else{
			black = false;
		}
	}
	
	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		String name;
		if (black){
			name = "bomb";
		} else{
			name = "bomb.white";
		}
		output.drawSprite(getSprite(name), getBox());
	}
}
