package platform.game;
import platform.util.*;

/**
 * Projectile class
 */
public class Projectile extends Actor{

	private Vector position;
	private Vector velocity;
	private double width;
	private double height;
	private Actor owner;
	private double elasticCoefficient;
	private double friction;
	
	public Projectile(Vector position, Vector velocity, double width, double height, Actor owner, double friction, double elasticCoefficient){
		if (velocity == null || position == null){
			throw new NullPointerException();
		}
		this.owner = owner;
		this.position = position;
		this.velocity = velocity;
		this.width = width;
		this.height = height;
		this.friction = friction;
		this.elasticCoefficient = elasticCoefficient;
	}
	
	@Override
	public int getPriority(){
		return 756;
	}
	
	@Override
	public Vector getPosition(){
		return position;
	}
	
	@Override
	public Vector getVelocity(){
		return velocity;
	}
	
	@Override
	public Box getBox(){
		return new Box(position, width, height);
	}
	
	public void setPosition(Vector vector){
		this.position = vector;
	}
	
	public void setVelocity(Vector velocity){
		this.velocity = velocity;
	}
	
	public Actor getOwner(){
		return owner;
	}
	
	public Vector getGravity(){
		return getWorld().getGravity();
	}
	
	@Override
	public void update(Input input){
		super.update(input);
		double delta = input.getDeltaTime();
		double scale = Math.pow(friction, input.getDeltaTime()) ;
		velocity = velocity.mul(scale);
		velocity = velocity.add(getGravity().mul(delta));
		position = position.add(velocity.mul(delta));
	}
	
	@Override
	public void interact(Actor other){
		super.interact(other);
		if (other.isSolid()) {
			Vector delta = other.getBox().getCollision(getBox());
			if (delta != null) {
				position = position.add(delta);
				velocity = new Vector(velocity.mirrored(delta).getX(), velocity.mirrored(delta).getY()*elasticCoefficient);
			}  
		}
	}
}














