package platform.game;

/**
 * Constant Signal
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
