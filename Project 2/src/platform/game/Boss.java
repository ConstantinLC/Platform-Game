package platform.game;
import platform.util.*; 

/**
 * Flying entity that throws fireballs towards the player
 */
public class Boss extends Actor implements Living{

	private Vector position;
	private Vector initial;
	private double size = 2;
	private Actor target;
	private double radius;
	private double current = 0;
	private boolean phase1 = true;
	private boolean phase2 = false;
	private boolean hasShot = false;
	private double shootingTimer;
	private double health;
	private double maxHealth;

	public Boss(Vector initial, double radius, Actor target, double maxHealth){
		this.initial = initial;
		this.position = initial;
		this.radius = radius;
		this.target = target;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
	}

	/**
	 * calculates the position of the boss according to a geometric function
	 */
	@Override
	public void update(Input input){
		current += input.getDeltaTime();
		if (health <= maxHealth/2){
			phase1 = false;
			phase2 = true;
		}

		double time = current%4*Math.PI;
		
		if (time > 2*Math.PI && time < 4*Math.PI){
			if (!hasShot){
				Fireball f = new Fireball(getBox().getCenter(), target.getPosition().sub(getBox().getCenter()), this, 1.5, false, "fireball_blue");
				getWorld().register(f);
				hasShot = true;
			}
		}

		if (hasShot){
			shootingTimer += input.getDeltaTime();
			if (shootingTimer > 0.5){
				hasShot = false;
				shootingTimer = 0;
			}
		}
		
		if (phase1)
			position = initial.add(new Vector(radius*Math.cos(2*current)*Math.cos(current), radius*Math.cos(2*current)*Math.sin(current))); //Rose
		if (phase2)
			position = initial.add(new Vector(radius*Math.cos(current) + 1.6*Math.cos(3*current/2),radius*Math.sin(current) - 1.6*Math.sin(3*current/2))); //Star
		
		if(health <= 0){
			getWorld().unregister(this);
		}
	}

	@Override
	public int getPriority(){
		return 200;
	}

	@Override
	public Box getBox(){
		return new Box(position, size, size);
	}

	@Override
	public void draw(Input input, Output output){
		super.draw(input, output);
		output.drawSprite(getSprite("flyMan_fly"), getBox());
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
	public double getHealth() {
		return health;
	}

	@Override
	public double getMaxHealth() {
		return maxHealth;
	}

}