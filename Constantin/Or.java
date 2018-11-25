package platform.game;

/**
 * Signal that is the logic equivalent of an OR logic gate, takes two signals as input
 */
public class Or implements Signal{

	private final Signal left;
	private final Signal right;
	
	public Or(Signal left, Signal right){
		if(left == null || right == null)
			throw new NullPointerException();
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean isActive() {
		return left.isActive() || right.isActive();
	}

}
