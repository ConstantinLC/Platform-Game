package platform.game;

/**
 * Signal that returns the opposite of another signal
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
