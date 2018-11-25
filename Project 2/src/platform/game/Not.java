package platform.game;

/**
 * Signal, logic equivalent to a negation, takes a signal as input
 */
public class Not implements Signal{

	private final Signal signal;
	
	public Not(Signal signal){
		if(signal == null)
			throw new NullPointerException();
		this.signal = signal;
	}
	
	@Override
	public boolean isActive() {
		return !signal.isActive();
	}

}
