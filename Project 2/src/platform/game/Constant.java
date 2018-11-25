package platform.game;

/**
 * Signal that never changes once created
 */
public class Constant implements Signal{
	private final boolean signal;
	
	public Constant(boolean signal){
		this.signal = signal;
	}

	@Override
	public boolean isActive() {
		return signal;
	}
	
}
