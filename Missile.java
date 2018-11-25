package platform.game;
import platform.util.*;

public class Missile extends Projectile{

	private double angle;
	private Actor owner;
	public double time;
	private Actor target;
	private boolean exploded = false;
	private Vector expected;
	private boolean first;
	private double speed = 2;
	private double rotationSpeed = 0.01;

	public Missile(Vector position, double width, double height, Actor owner, Actor target, double angle){
		super(position, Vector.ZERO, width, height, owner, 1, 1); 
		this.angle = super.getVelocity().getAngle();
		this.target = target;
	}

	public double getAngle(){
		return angle;
	}

	public Box getBox(){
		return super.getBox();
	}
	
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

	public void draw(Input input, Output output){
		if (!exploded){
			output.drawSprite(getSprite("blade.saw"), super.getBox(),input.getTime() * 10);
		}
	}

	public void interact(Actor other){
		if (other.isSolid()){
			if (this.getBox().isColliding(other.getBox())){
				exploded = true;
				getWorld().unregister(this);
			}
		}
		if (!other.isSolid()){
			if (this.getBox().isColliding(other.getBox())){
				if (other.hurt(this, Damage.PHYSICAL, 0.01, super.getPosition())){
					exploded = true;
					getWorld().unregister(this);
				}
			}
		}
	}


}
