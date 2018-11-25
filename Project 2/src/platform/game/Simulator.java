package platform.game;

import platform.game.Actor.Damage;
import platform.game.level.Level;
import java.util.ArrayList;
import java.util.List;
import platform.util.Box;

import platform.util.Input;
import platform.util.Loader;
import platform.util.Output;
import platform.util.SortedCollection;
import platform.util.Vector;
import platform.util.View;

/**
 * Basic implementation of world, managing a complete collection of actors.
 */
public class Simulator implements World {

	private Level next;
	private boolean transition;
	
	private SortedCollection<Actor> actors;
	private List<Actor> registered;
	private List<Actor> unregistered;
	
    private Loader loader;
    private Vector currentCenter ;
    private Vector expectedCenter;
    private double currentRadius ;
    private double expectedRadius;
  
    /**
     * Create a new simulator.
     * @param loader associated loader, not null
     * @param args level arguments, not null
     */
	public Simulator(Loader loader, String[] args) {
        if (loader == null)
            throw new NullPointerException();
        this.loader = loader;
        currentCenter = Vector.ZERO;
        currentRadius = 10.0;
        expectedCenter = Vector.ZERO;
        expectedRadius = 10.0;
        registered = new ArrayList<Actor>();
        unregistered = new ArrayList<Actor>();
        actors = new SortedCollection<Actor>();
        transition = true;
	}
	
    /**
     * Simulate a single step of the simulation.
     * @param input input object to use, not null
     * @param output output object to use, not null
     */
	public void update(Input input, Output output) {
        
		double factor = 0.08 ;
		currentCenter = currentCenter.mul(1.0 -	factor).add(expectedCenter.mul(factor)) ;
		currentRadius = currentRadius * (1.0 - factor) + expectedRadius * factor ;
		
		View view = new View(input , output) ;
		view.setTarget(currentCenter , currentRadius) ;
		
		// preUpdate
		for (Actor a : actors)
			a.preUpdate(view) ;
		// Apply interactions
		for (Actor actor : actors)
			for(Actor other : actors)
				if(actor.getPriority() > other.getPriority())
					actor.interact(other);
		// Apply update
		for (Actor a : actors)
			a.update(view) ;
		// postUpdate
		for (Actor a : actors)
			a.postUpdate(view) ;
		// Draw everything
		for (Actor a : actors.descending()) // sera retouch�e un peu plus loin
			a.draw(view, view) ;
		
		// Add registered actors
		for (int i = 0 ; i < registered.size() ; ++i) {
			Actor actor = registered.get(i) ;
			if ( !actors.contains(actor)) {
				actors.add(actor) ;
				actor.register(this);
			}
		}
		registered.clear() ;
		
		// Remove unregistered actors
		for (int i = 0 ; i < unregistered.size() ; ++i) {
			Actor actor = unregistered.get(i) ;
			actors.remove(actor) ;
			actor.unregister();
		}
		unregistered.clear() ;
	
		// si un acteur a mis transition � true pour demander le passage
		// � un autre niveau :
		if (transition) {
		if (next == null) {
		next = Level.createDefaultLevel() ;
		}
		// si un acteur a appel� setNextLevel , next ne sera pas null :
		Level level = next ;
		transition = false ;
		next = null ;
		actors.clear() ;
		registered.clear() ;
		// tous les anciens acteurs sont d�senregistr�s ,
		// y compris le Level pr�c�dent :
		unregistered.clear() ;
		register(level) ;
		}

		
	}

	@Override
	public void setView(Vector center , double radius){
		if(center == null)
			throw new NullPointerException();
		if(radius <= 0.0)
			throw new IllegalArgumentException("radius must be positive");
		expectedCenter = center;
		expectedRadius = radius;
	}
	
    @Override
    public Loader getLoader() {
        return loader;
    }

    @Override
    public void register(Actor actor) {
    	registered.add(actor) ;
    }
    @Override
    public void unregister(Actor actor) {
    	unregistered.add(actor) ;
    }

	
    @Override
	public void nextLevel() {
		transition = true;
		
	}
    

	@Override
	public void setNextLevel(Level level) {
		next = level;
	}
    
	@Override
	public int hurt(Box area, Actor instigator , Damage type, double amount , Vector location) {
		int victims = 0 ;
		for (Actor actor : actors)
			if (area.isColliding(actor.getBox()))
				if (actor.hurt(instigator , type, amount , location))
					++victims ;
	return victims ;
	}
}
