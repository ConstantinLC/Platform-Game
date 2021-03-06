package platform.game;
import platform.util.*;

/**
 * Projectile that follows the player with a limited turning speed
 */
public class BladeSaw extends Projectile{

	private double angle;
	public double time;
	private Actor target;
	private double speed = 2;
	private double rotationSpeed = 0.01;
	private static double explosionDuration = 0.5;

	public BladeSaw(Vector position, double size, Actor owner, Actor target, double angle){
		super(position, Vector.ZERO, size, size, owner, 1, 1); 
		this.angle = angle;
		this.target = target;
	}

	public double getAngle(){
		return angle;
	}

	@Override
	public Box getBox(){
		return super.getBox();
	}

	@Override
	public void update(Input input){
		double wantedAngle = target.getPosition().sub(getPosition()).getAngle();
		double currentAngle = angle%(2*Math.PI);
		double angleDif = (wantedAngle - currentAngle);
		while(angleDif < 0 || angleDif > (2*Math.PI)){
			if(angleDif < 0)
				angleDif += (2*Math.PI);
			if(angleDif > (2*Math.PI))
				angleDif -= (2*Math.PI);
		}
		if(angleDif > Math.PI ){
			angle += rotationSpeed;
		} else{
			angle -= rotationSpeed;
		}

		super.setVelocity(new Vector (speed, 0).rotated(angle + Math.PI));
		super.update(input);
	}

	@Override
	public void draw(Input input, Output output){
		output.drawSprite(getSprite("blade.saw"), super.getBox(),input.getTime() * 10);
	}

	@Override
	public void interact(Actor other){
		if (getBox().isColliding(other.getBox())){
			if(other.hurt(this, Damage.PHYSICAL, 0.01, super.getPosition()) || other.isSolid()){
				getWorld().register(new Particle(getPosition(), super.getBox().getInnerRadius(), explosionDuration, "explosions/explosion.", 24));
				getWorld().unregister(this);
			}
			if(other.hurt(this, Damage.FIRE, 0.1, super.getPosition()) || other.isSolid()){

			}
		}
	}
}
