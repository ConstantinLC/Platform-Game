package platform.game;

import java.awt.event.KeyEvent;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Player extends Actor{

	private double health;
	private double maxHealth;
	private Vector position;
	private Vector velocity;
	private boolean colliding;
	private Vector deltaPosition;
	private boolean teleporting;
	private Vector teleportingDestination;
	private double teleportingTime;
	private Vector teleportPosition;

	private boolean fireball = false;
	private boolean doubleJump = false;
	private boolean bombs = false;
	private boolean switchGravity = false;

	private boolean direction = true;		//true = down, false = up
	private int airJumps;

	public Player(Vector position, Vector velocity, double health, double maxHealth){
		if(position == null || velocity == null)
			throw new NullPointerException();
		this.position = position;
		this.velocity = velocity;
		this.health = health;
		this.maxHealth = maxHealth;
		this.airJumps = 0;
	}

	public Vector getPosition() {
		return teleporting ? teleportPosition : position;
	}

	public double getHealth(){
		return health;
	}

	public double getMaxHealth(){
		return maxHealth;
	}

	@Override
	public Box getBox() {
		super.getBox();
		if(!teleporting)
			return new Box(position, 0.8, 0.8);
		return new Box(teleportPosition, 0.8*teleportingTime, 0.8*teleportingTime);
	}

	@Override
	public Vector getVelocity(){
		super.getVelocity();
		return velocity;
	}

	@Override
	public int getPriority() {
		return 42;
	}

	@Override
	public void preUpdate(Input input) {
		super.preUpdate(input);
		colliding  = false;
		deltaPosition = Vector.ZERO;
	}

	public void setDeltaPosition(Vector vector){
		this.deltaPosition = vector;
	}

	@Override
	public void interact(Actor other) {
		super.interact(other) ;
		if (other.isSolid() && other.getBox() != null) {
			if(other.hurt(this, Damage.COLLIDING, 1.0, getPosition())){
				position = position.add(deltaPosition);
			}

			Vector delta = other.getBox().getCollision(getBox()) ;
			if (delta != null) {
				colliding = true;
				airJumps = 0;
				position = position.add(delta) ;
				if (delta.getX() != 0.0)
					velocity = new Vector(0.0, velocity.getY()) ;
				if (delta.getY() != 0.0)
					velocity = new Vector(velocity.getX(), 0.0) ;
			}
		} else{
			if(other.getClass() == Exit.class && this.getBox().isColliding(other.getBox())){
				getWorld().hurt(getBox(), this , Damage.ACTIVATION, 1.0, getPosition());
			}
		}
	}

	@Override
	public void update(Input input) {
		super.update(input);

		double maxSpeed = 4.0 ;
		super.update(input) ;

		if (colliding) {
			double scale = Math.pow(0.001, input.getDeltaTime()) ;
			velocity = velocity.mul(scale);
		}
		if(!teleporting){
			if (input.getKeyboardButton(KeyEvent.VK_RIGHT).isDown()) {
				if (velocity.getX() < maxSpeed) {
					double increase = 60.0 * input.getDeltaTime() ;
					double speed = velocity.getX() + increase ;
					if (speed > maxSpeed)
						speed = maxSpeed ;
					velocity = new Vector(speed , velocity.getY()) ;
				}
			}
			if (input.getKeyboardButton(KeyEvent.VK_LEFT).isDown()) {
				if (velocity.getX() > -maxSpeed) {
					double increase = 60.0 * input.getDeltaTime() ;
					double speed = velocity.getX() - increase ;
					if (speed < -maxSpeed)
						speed = -maxSpeed ;
					velocity = new Vector(speed , velocity.getY()) ;
				}
			}
			if (input.getKeyboardButton(KeyEvent.VK_UP).isPressed() && (colliding || (airJumps < 1 && doubleJump))){
				velocity = new Vector(velocity.getX(), (direction ? 1 : -1) * 6.0);
				if(!colliding)
					++airJumps;
			}
			if (input.getKeyboardButton(KeyEvent.VK_SPACE).isPressed() && fireball){
				getWorld().register(new Fireball(position, velocity.add(velocity.resized(2.0)), this));
			}
			if (input.getKeyboardButton(KeyEvent.VK_B).isPressed())
				getWorld().hurt(getBox(), this , Damage.AIR, 1.0, getPosition());
			if (input.getKeyboardButton(KeyEvent.VK_E).isPressed())
				getWorld().hurt(getBox(), this , Damage.ACTIVATION, 1.0, getPosition());

			//upgrades
			if(switchGravity && input.getKeyboardButton(KeyEvent.VK_SHIFT).isDown() && colliding){
				direction = !direction;
			}
			if (input.getKeyboardButton(KeyEvent.VK_C).isPressed() && bombs) {
				Vector v = velocity.add(velocity.resized(2.0));
				System.out.println(v);
				Bomb b = new Bomb(position, v, this, 0.3, 0.8);
				getWorld().register(b);
			}
		}


		double delta = input.getDeltaTime();
		Vector acceleration = Vector.ZERO;
		if(!teleporting)
			acceleration = getGravity();
		velocity = velocity.add(acceleration.mul(delta));
		position = position.add(velocity.mul(delta));

		if(teleporting){
			if(teleportingTime > (0+input.getDeltaTime())){
				teleportingTime -= input.getDeltaTime();
			} else{
				position = teleportingDestination;
				teleporting = false;
			}
		}

		if(health <= 0){
			killThis();
		}
	}

	@Override
	public void postUpdate(Input input) {
		super.postUpdate(input);
		getWorld().setView(getPosition(), 10.0);
	}



	@Override
	public void draw(Input input , Output output) {
		super.draw(input, output);

		String sprite = direction ? "blocker.happy" : "blocker.happy.flip";

		if(teleporting){
			output.drawSprite(getSprite(sprite), getBox(), 1/teleportingTime -1);
		} else
			output.drawSprite(getSprite(sprite), getBox());
	}

	@Override
	public boolean hurt(Actor instigator , Damage type, double amount , Vector location) {
		switch (type) {
		case AIR :
			velocity = getPosition().sub(location).resized(amount) ;
			return true ;
		case VOID :
			health -= amount;
			return true;
		case HEAL :
			health += amount;
			if(health > maxHealth)
				health = maxHealth;
			return true;
		case PHYSICAL :
			health -= amount;
			return true;
		case FIRE :
			this.health -= amount;
			return true;
		case ACTIVATION :
			return true;
		case TELEPORTATION :
			animateTeleportation(location, amount);
			return true;
		case UPGRADE :
			if(amount == Upgrade.FIREBALLUPGRADE){
				fireball = true;
				return true;
			} else if(amount == Upgrade.DOUBLEJUMPUPGRADE){
				doubleJump = true;
				return true;
			} else if(amount == Upgrade.BOMBUPGRADE){
				bombs = true;
				return true;
			} else if(amount == Upgrade.GRAVITYUPGRADE){
				switchGravity = true;
				return true;
			}
			return false;
		default :
			return super.hurt(instigator , type, amount , location) ;
		}
	}

	public void killThis(){
		getWorld().setNextLevel(null);
		getWorld().nextLevel();
	}

	private Vector getGravity(){
		return direction ? getWorld().getGravity() : getWorld().getGravity().opposite();
	}

	private void animateTeleportation(Vector location, double time){
		teleporting = true;
		teleportingDestination = location;
		teleportingTime = time;
		teleportPosition = position;
	}
}
