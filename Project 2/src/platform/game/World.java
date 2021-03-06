package platform.game;

import platform.game.Actor.Damage;
import platform.game.level.Level;
import platform.util.Box;
import platform.util.Loader;
import platform.util.Vector;

/**
 * Represents an environment populated by actors.
 */
public interface World {

    /** @return associated loader, not null */
    public Loader getLoader();
  
    /**
    * Set viewport location and size.
    * @param center viewport center , not null
    * @param radius viewport radius , positive
    */
    public void setView(Vector center , double radius) ;

    public void register(Actor actor);
    
    public void unregister(Actor actor);  
    
    default Vector getGravity(){
    	return new Vector(0.0, -9.81);
    }
    
	// permet d'indiquer que la transition a un autre niveau
	// doit se faire :
	public void nextLevel() ;
	// permet de passer au niveau level :
	public void setNextLevel(Level level) ;

	public int hurt(Box area, Actor instigator, Damage type, double amount, Vector location);
}
