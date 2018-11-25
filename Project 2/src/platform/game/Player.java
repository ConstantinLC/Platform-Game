package platform.game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import platform.util.*;

/**
 * Player controlled actor
 */
public class Player extends Actor implements Living{

	private double health;
	private double maxHealth;
	private Vector position;
	private Vector velocity;
	private boolean colliding;
	private Vector deltaPosition;
	private Vector respawnPosition = new Vector(0,1);
	private boolean teleporting;
	private Vector teleportingDestination;
	private double teleportingTime;
	private Vector teleportPosition;
	
	
	private boolean respawn; //True if the player respawns with already obtained upgrades, false if the world totally reloads
	
	private double fireballTimer = 0.5;
	private double fireballCooldown = fireballTimer;

	private boolean fireball = false;
	private boolean doubleJump = false;
	private boolean bombs = false;
	private boolean switchGravity = false;

	private boolean direction = true;		//true = down, false = up
	private int airJumps;

	public Player(Vector position, Vector velocity, double health, double maxHealth, boolean respawn){
		if(position == null || velocity == null)
			throw new NullPointerException();
		this.position = position;
		this.velocity = velocity;
		this.health = health;
		this.maxHealth = maxHealth;
		this.airJumps = 0;
		this.respawn = respawn;
	}
	
	public Player(Vector position, Vector velocity, double health, double maxHealth, boolean respawn, boolean fireball, boolean doubleJump, boolean bombs, boolean switchGravity){
		this(position, velocity, health, maxHealth, respawn);
		this.fireball = fireball;
		this.doubleJump = doubleJump;
		this.bombs = bombs;
		this.switchGravity = switchGravity;
	}

	@Override
	public Vector getPosition() {
		return teleporting ? teleportPosition : position;
	}

	@Override
	public double getHealth(){
		return health;
	}

	@Override
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
			//if he's on a mover, he gets dragged along
			if(other.hurt(this, Damage.COLLIDING, 1.0, getPosition())){
				position = position.add(deltaPosition);
			}
			
			//if in collision move to get out of the collision
			Vector delta = other.getBox().getCollision(getBox()) ;
			if (delta != null) {
				if(direction && delta.getY() > 0){
					colliding = true;
					airJumps = 0;
				} else if(!direction && delta.getY() < 0){
					colliding = true;
					airJumps = 0;
				}
				position = position.add(delta) ;
				if (delta.getX() != 0.0)
					velocity = new Vector(0.0, velocity.getY()) ;
				if (delta.getY() != 0.0)
					velocity = new Vector(velocity.getX(), 0.0) ;
			}
		} else{
			//automatically avtivate exits on collision
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

		//friction on collision
		if (colliding) {
			double scale = Math.pow(0.001, input.getDeltaTime()) ;
			velocity = velocity.mul(scale);
		}
		if(!teleporting){
			//move right
			if (input.getKeyboardButton(KeyEvent.VK_D).isDown()) {
				if (velocity.getX() < maxSpeed) {
					double increase = 60.0 * input.getDeltaTime() ;
					double speed = velocity.getX() + increase ;
					if (speed > maxSpeed)
						speed = maxSpeed ;
					velocity = new Vector(speed , velocity.getY()) ;
				}
			}
			//move left
			if (input.getKeyboardButton(KeyEvent.VK_A).isDown()) {
				if (velocity.getX() > -maxSpeed) {
					double increase = 60.0 * input.getDeltaTime() ;
					double speed = velocity.getX() - increase ;
					if (speed < -maxSpeed * (direction ? 1:-1))
						speed = -maxSpeed ;
					velocity = new Vector(speed , velocity.getY()) ;
				}
			}
			//jump
			if (input.getKeyboardButton(KeyEvent.VK_W).isPressed() && (colliding || (airJumps < 1 && doubleJump))){
				velocity = new Vector(velocity.getX(), (direction ? 1 : -1) * 6.0);
				if(!colliding)
					++airJumps;
			}
			//air damage
			if (input.getKeyboardButton(KeyEvent.VK_B).isPressed())
				getWorld().hurt(getBox(), this , Damage.AIR, 1.0, getPosition());
			//activation
			if (input.getKeyboardButton(KeyEvent.VK_E).isPressed())
				getWorld().hurt(getBox(), this , Damage.ACTIVATION, 1.0, getPosition());
			//fireball
			if (input.getMouseButton(MouseEvent.BUTTON1).isPressed() && fireball && fireballCooldown < 0){
				Fireball f  = new Fireball(this.getPosition(), (input.getMouseLocation().sub(this.getPosition())).resized(12), this, 3.0, true, "fireball");
				getWorld().register(f);
				fireballCooldown = fireballTimer;
			}
			//alternate fireball button
			if (input.getKeyboardButton(KeyEvent.VK_SPACE).isPressed() && fireball && fireballCooldown < 0){
				 getWorld().register(new Fireball(position, velocity.getX() >= 0 ? new Vector(5, direction ? velocity.getY()+3 : -velocity.getY()-3) : new Vector(-5, direction ? velocity.getY()+3 : -velocity.getY()-3), this, 3, true, "fireball"));
				 fireballCooldown = fireballTimer;
			}
			//bombs
			if (input.getMouseButton(MouseEvent.BUTTON3).isPressed() && bombs){
				Bomb b = new Bomb(position, Vector.ZERO, this, 0.2, 0.5); 
				getWorld().register(b);
			}
			//switch gravity
			if(switchGravity && input.getKeyboardButton(KeyEvent.VK_SHIFT).isPressed()){
				direction = !direction;
			}			
			
		}

		fireballCooldown -= input.getDeltaTime();
		
		double delta = input.getDeltaTime();
		Vector acceleration = Vector.ZERO;
		//if not teleporting, add the velocity normally
		if(!teleporting)
			acceleration = getGravity();
		velocity = velocity.add(acceleration.mul(delta));
		position = position.add(velocity.mul(delta));

		//if teleporting, continue the teleportation animation
		if(teleporting){
			if(teleportingTime > (0+input.getDeltaTime())){
				teleportingTime -= input.getDeltaTime();
			} else{
				position = teleportingDestination;
				velocity = Vector.ZERO;
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
		case CHECKPOINT:
			respawnPosition = location;
			return true;
		default :
			return super.hurt(instigator , type, amount , location) ;
		}
	}

	public void killThis(){
		if (!respawn){
			getWorld().nextLevel();
		}
		else{
			health = maxHealth;
			position = respawnPosition;
		}
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
