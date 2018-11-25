package platform.game;
import platform.util.*;

/**
 * Slime Boss, spawns lesser versions of itself on death till it reaches a certain size
 */
public class SlimeBoss extends Actor implements Living{

	private Vector position;
	private double width;
	private double height;
	private Vector velocity;
	private double maxHealth = 8;
	private double health;
	private boolean colliding;

	public SlimeBoss(Vector position, double width, double height, boolean direction, double maxHealth){
		this.position = position;
		this.maxHealth = maxHealth;
		this.width = width;
		this.height = height;
		health = maxHealth;
		if (direction){
			this.velocity = new Vector(-2,0);
		} else{
			this.velocity = new Vector(2,0);
		}
	}

	@Override
	public int getPriority(){
		return 160;
	}

	@Override
	public Box getBox(){
		return new Box(position, width, height);
	}

	@Override
	public void preUpdate(Input input){
		colliding = false;
	}
	
	@Override
	public void interact(Actor other) {
		super.interact(other) ;
		if (other.isSolid() && other.getBox() != null) {
			Vector delta = other.getBox().getCollision(getBox()) ;
			if (delta != null) {
				colliding = true;
				position = position.add(delta) ;
				if (delta.getX() != 0.0)
					velocity = new Vector(-velocity.getX(), velocity.getY()) ;
				if (delta.getY() != 0.0)
					velocity = new Vector(velocity.getX(), 0.0) ;
			}
		}
		if(getBox().isColliding(other.getBox()))
			other.hurt(this, Damage.PHYSICAL, 0.05, position);
	}
	
	@Override
	public void update(Input input){
		super.update(input);

		if (Math.random() < 0.01 && colliding){
			velocity = velocity.add(new Vector(0, 6+2*Math.log(width)));
		}
		
		double delta = input.getDeltaTime();
		velocity = velocity.add(getWorld().getGravity().mul(delta));
		position = position.add(velocity.mul(delta));
		//spawns lesser versions of itself upon death if large enough
		if (health <= 0){
			if (width >= 1){
				getWorld().register(new SlimeBoss(this.getPosition(), width/2, height/2, true, maxHealth/2));
				getWorld().register(new SlimeBoss(this.getPosition(), width/2, height/2, false, maxHealth/2));
			}
			getWorld().unregister(this);
		}
	}

	@Override
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
		case VOID :
			health -= amount;
			return true;
		case FIRE :
			this.health -= amount;
			return true;
		default :
			return super.hurt(instigator , type, amount , location) ;
		}
	}

	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		if (velocity.getX() < 0)
			output.drawSprite(getSprite("slime.left.1"), getBox());
		else
			output.drawSprite(getSprite("slime.right.1"), getBox());
	}

	@Override
	public double getHealth() {
		return health;
	}

	@Override
	public double getMaxHealth() {
		return maxHealth;
	}


}







