package platform.game;
import platform.util.*;

/**
 * Signal that alternates between off and on according to a timer
 */
public class Clock extends Actor implements Signal{

	private double time;
	private double timeElapsed = 0;
	private boolean on = false;
	
	public Clock(double time){
		this.time = time;
	}
	
	@Override
	public void update(Input input){
		timeElapsed += input.getDeltaTime();
		if (timeElapsed > time){
			on = !on;
			timeElapsed = 0;
		}
	}
	
	@Override
	public int getPriority(){
		return 30;
	}
	
	@Override
	public boolean isActive(){
		return on;
	}
}
