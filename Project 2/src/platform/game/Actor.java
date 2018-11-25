package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Vector;
import platform.util.Output;
import platform.util.Sprite;

/**
 * Base class of all simulated actors, attached to a world.
 */
public abstract class Actor implements Comparable<Actor> {

	private World world;
	static protected enum Damage{FIRE, PHYSICAL, AIR, VOID, ACTIVATION, HEAL, COLLIDING, TELEPORTATION, UPGRADE, EXPLOSION, CHECKPOINT};
	
	// preUpdate :
	public void preUpdate(Input input) {}
	// pour �voluer au cours du temps :
	public void update(Input input) {}
	// postUpdate :
	public void postUpdate(Input input) {}
	// pour �tre dessin�
	public void draw(Input input , Output output) {}
	
	abstract public int getPriority();
	
	@Override
	public int compareTo(Actor other){
		if(this.getPriority() > other.getPriority()){
			return -1;
		} else if(this.getPriority() == other.getPriority()){
			return 0;
		} else{
			return 1;
		}
	}
	
	public boolean isSolid() {
		return false ;
	}
	
	public Box getBox() {
		return null ;
	}
	
	public Vector getVelocity(){
		return Vector.ZERO;
	}
	
	public Vector getPosition() {
		Box box = getBox() ;
		if (box == null)
			return null ;
		return box.getCenter() ;
	}
	
	public void interact(Actor other){}
	
	public void register(World world) {
		this.world = world ;
	}
	public void unregister() {
		world = null ;
	}
	
	protected World getWorld(){
		return world;
	}

	protected Sprite getSprite(String sprite){
		return world.getLoader().getSprite(sprite);
	}

	public boolean hurt(Actor instigator, Damage type, double amount, Vector location){
		return false;
	}
}