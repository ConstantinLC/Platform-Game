package platform.game.level;

import platform.game.*;
import platform.util.*;

public class LevelGG extends Level{

	public void register(World world) {
		super.register(world);

		// Register a new instance, to restart level automatically
		world.setNextLevel(new LevelGG());
		
		// Create blocks
		Player player = new Player(new Vector(0,0), new Vector(0,0), 6.0, 6.0, false, true, true, true ,true);
		world.register(player);

		world.register(new Overlay(player));
		world.register(new Background(new Vector(-2,0.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(-0.5,0.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(1,0.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(-4.5,1.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(-3.5,1.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(5,1.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(3.5,0.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(-6.5,2.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(6.5,2.5), 1, 1, "blocker.happy"));
		world.register(new Background(new Vector(0, 20), 40, 40, "dirt"));
		world.register(new Message(new Vector(1, 7), 15, 2, 18, new Constant(true)));
		
		world.register(new Block(new Box(new Vector(-3, -1), new Vector(4, 0)), world.getLoader().getSprite("grass.middle"), 7, "X"));
		world.register(new Block(new Box(new Vector(4, 0), new Vector(6, 1)), world.getLoader().getSprite("grass.middle"), 2, "X"));
		world.register(new Block(new Box(new Vector(-5, 0), new Vector(-3, 1)), world.getLoader().getSprite("grass.middle"), 2, "X"));
		world.register(new Block(new Box(new Vector(6, 1), new Vector(8, 2)), world.getLoader().getSprite("grass.middle"), 2, "X"));
		world.register(new Block(new Box(new Vector(-7, 1), new Vector(-5, 2)), world.getLoader().getSprite("grass.middle"), 2, "X"));
		world.register(new Block(new Box(new Vector(8, 2), new Vector(9, 3)), world.getLoader().getSprite("grass.middle"), 1, "X"));
		world.register(new Block(new Box(new Vector(-8, 2), new Vector(-7, 3)), world.getLoader().getSprite("grass.middle"), 1, "X"));
		world.register(new Block(new Box(new Vector(9, 3), new Vector(10, 5)), world.getLoader().getSprite("grass.middle"), 2, "Y"));
		world.register(new Block(new Box(new Vector(-9, 3), new Vector(-8, 5)), world.getLoader().getSprite("grass.middle"), 2, "Y"));
		world.register(new Block(new Box(new Vector(10, 5), new Vector(11, 7)), world.getLoader().getSprite("grass.middle"), 2, "Y"));
		world.register(new Block(new Box(new Vector(-10, 5), new Vector(-9, 7)), world.getLoader().getSprite("grass.middle"), 2, "Y"));
		world.register(new Block(new Box(new Vector(11, 7), new Vector(12, 14)), world.getLoader().getSprite("grass.middle"), 7, "Y"));
		world.register(new Block(new Box(new Vector(-11, 7), new Vector(-10, 14)), world.getLoader().getSprite("grass.middle"), 7, "Y"));
		world.register(new Block(new Box(new Vector(-10, 14), new Vector(-9, 16)), world.getLoader().getSprite("grass.middle"), 2, "Y"));
		world.register(new Block(new Box(new Vector(10, 14), new Vector(11, 16)), world.getLoader().getSprite("grass.middle"), 2, "Y"));
		world.register(new Block(new Box(new Vector(-9, 16), new Vector(-8, 18)), world.getLoader().getSprite("grass.middle"), 2, "Y"));
		world.register(new Block(new Box(new Vector(9, 16), new Vector(10, 18	)), world.getLoader().getSprite("grass.middle"), 2, "Y"));
		world.register(new Block(new Box(new Vector(8, 18), new Vector(9, 19)), world.getLoader().getSprite("grass.middle"), 1, "X"));
		world.register(new Block(new Box(new Vector(-8, 18), new Vector(-7, 19)), world.getLoader().getSprite("grass.middle"), 1, "X"));
		world.register(new Block(new Box(new Vector(-7, 19), new Vector(-5, 20)), world.getLoader().getSprite("grass.middle"), 2, "X"));
		world.register(new Block(new Box(new Vector(6, 19), new Vector(8, 20)), world.getLoader().getSprite("grass.middle"), 2, "X"));
		world.register(new Block(new Box(new Vector(-5, 20), new Vector(-3, 21)), world.getLoader().getSprite("grass.middle"), 2, "X"));
		world.register(new Block(new Box(new Vector(4, 20), new Vector(6, 21)), world.getLoader().getSprite("grass.middle"), 2, "X"));
		world.register(new Block(new Box(new Vector(-3, 21), new Vector(4, 22)), world.getLoader().getSprite("grass.middle"), 7, "X"));
		
		world.register(new Block(new Box(new Vector(4, -1), new Vector(14, 0)), world.getLoader().getSprite("castle.center"), 10, "X"));
		world.register(new Block(new Box(new Vector(5, 0), new Vector(14, 1)), world.getLoader().getSprite("castle.center"), 9, "X"));
		world.register(new Block(new Box(new Vector(6, 1), new Vector(14, 2)), world.getLoader().getSprite("castle.center"), 8, "X"));
		world.register(new Block(new Box(new Vector(9, 2), new Vector(14, 3)), world.getLoader().getSprite("castle.center"), 5, "X"));
		world.register(new Block(new Box(new Vector(10, 3), new Vector(14, 4)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 4), new Vector(14, 5)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 5), new Vector(14, 6)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 6), new Vector(14, 7)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(11, 7), new Vector(14, 8)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(11, 8), new Vector(14, 9)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(11, 9), new Vector(14, 10)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(11, 10), new Vector(14, 11)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(11, 11), new Vector(14, 12)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(11, 12), new Vector(14, 13)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(11, 13), new Vector(14, 14)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(10, 14), new Vector(14, 15)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 15), new Vector(14, 16)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 15), new Vector(14, 16)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 15), new Vector(14, 16)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 15), new Vector(14, 16)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 16), new Vector(14, 17)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(10, 17), new Vector(14, 18)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(9, 18), new Vector(14, 19)), world.getLoader().getSprite("castle.center"), 5, "X"));
		world.register(new Block(new Box(new Vector(8, 19), new Vector(14, 20)), world.getLoader().getSprite("castle.center"), 6, "X"));
		world.register(new Block(new Box(new Vector(6, 20), new Vector(14, 21)), world.getLoader().getSprite("castle.center"), 8, "X"));
		world.register(new Block(new Box(new Vector(4, 21), new Vector(14, 22)), world.getLoader().getSprite("castle.center"), 10, "X"));

		world.register(new Block(new Box(new Vector(-13, -1), new Vector(-3, 0)), world.getLoader().getSprite("castle.center"), 10, "X"));
		world.register(new Block(new Box(new Vector(-13, 0), new Vector(-4, 1)), world.getLoader().getSprite("castle.center"), 9, "X"));
		world.register(new Block(new Box(new Vector(-13, 1), new Vector(-5, 2)), world.getLoader().getSprite("castle.center"), 8, "X"));
		world.register(new Block(new Box(new Vector(-13, 2), new Vector(-7, 3)), world.getLoader().getSprite("castle.center"), 6, "X"));
		world.register(new Block(new Box(new Vector(-13, 3), new Vector(-8, 4)), world.getLoader().getSprite("castle.center"), 5, "X"));
		world.register(new Block(new Box(new Vector(-13, 4), new Vector(-9, 5)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(-13, 5), new Vector(-10, 6)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(-13, 6), new Vector(-10, 7)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(-13, 7), new Vector(-11, 8)), world.getLoader().getSprite("castle.center"), 2, "X"));
		world.register(new Block(new Box(new Vector(-13, 8), new Vector(-11, 9)), world.getLoader().getSprite("castle.center"), 2, "X"));
		world.register(new Block(new Box(new Vector(-13, 9), new Vector(-11, 10)), world.getLoader().getSprite("castle.center"), 2, "X"));
		world.register(new Block(new Box(new Vector(-13, 10), new Vector(-11, 11)), world.getLoader().getSprite("castle.center"), 2, "X"));
		world.register(new Block(new Box(new Vector(-13, 11), new Vector(-11, 12)), world.getLoader().getSprite("castle.center"), 2, "X"));
		world.register(new Block(new Box(new Vector(-13, 12), new Vector(-11, 13)), world.getLoader().getSprite("castle.center"), 2, "X"));
		world.register(new Block(new Box(new Vector(-13, 13), new Vector(-11, 14)), world.getLoader().getSprite("castle.center"), 2, "X"));
		world.register(new Block(new Box(new Vector(-13, 14), new Vector(-10, 15)), world.getLoader().getSprite("castle.center"), 3, "X"));
		world.register(new Block(new Box(new Vector(-13, 15), new Vector(-9, 16)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(-13, 16), new Vector(-9, 17)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(-13, 17), new Vector(-9, 18)), world.getLoader().getSprite("castle.center"), 4, "X"));
		world.register(new Block(new Box(new Vector(-13, 18), new Vector(-8, 19)), world.getLoader().getSprite("castle.center"), 5, "X"));
		world.register(new Block(new Box(new Vector(-13, 19), new Vector(-7, 20)), world.getLoader().getSprite("castle.center"), 6, "X"));
		world.register(new Block(new Box(new Vector(-13, 20), new Vector(-5, 21)), world.getLoader().getSprite("castle.center"), 8, "X"));
		world.register(new Block(new Box(new Vector(-13, 21), new Vector(-3, 22)), world.getLoader().getSprite("castle.center"), 10, "X"));
		world.register(new Block(new Box(new Vector(-13, -2), new Vector(14, -1)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -3), new Vector(14, -2)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -4), new Vector(14, -3)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -5), new Vector(14, -4)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -6), new Vector(14, -5)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -7), new Vector(14, -6)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -8), new Vector(14, -7)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -9), new Vector(14, -8)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -10), new Vector(14, -9)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -11), new Vector(14, -10)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -12), new Vector(14, -11)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -13), new Vector(14, -12)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, -14), new Vector(14, -13)), world.getLoader().getSprite("castle.center"), 27, "X"));

		world.register(new Block(new Box(new Vector(-13, 22), new Vector(14, 23)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 23), new Vector(14, 24)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 24), new Vector(14, 25)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 25), new Vector(14, 26)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 26), new Vector(14, 27)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 27), new Vector(14, 28)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 28), new Vector(14, 29)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 29), new Vector(14, 30)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 30), new Vector(14, 31)), world.getLoader().getSprite("castle.center"), 27, "X"));

		world.register(new Block(new Box(new Vector(-15, -13), new Vector(-14, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-14, -13), new Vector(-13, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));

		world.register(new Block(new Box(new Vector(-13, 30), new Vector(14, 31)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 30), new Vector(14, 31)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-13, 30), new Vector(14, 31)), world.getLoader().getSprite("castle.center"), 27, "X"));
		world.register(new Block(new Box(new Vector(-16, -13), new Vector(-15, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-17, -13), new Vector(-16, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-18, -13), new Vector(-17, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-19, -13), new Vector(-18, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-20, -13), new Vector(-19, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-21, -13), new Vector(-20, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-22, -13), new Vector(-21, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-23, -13), new Vector(-22, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-24, -13), new Vector(-23, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-25, -13), new Vector(-24, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-26, -13), new Vector(-25, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(-27, -13), new Vector(-26, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		
		world.register(new Block(new Box(new Vector(14, -13), new Vector(15, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(15, -13), new Vector(16, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(16, -13), new Vector(17, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(17, -13), new Vector(18, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(18, -13), new Vector(19, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(19, -13), new Vector(20, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(20, -13), new Vector(21, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(21, -13), new Vector(22, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(22, -13), new Vector(23, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(23, -13), new Vector(24, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(24, -13), new Vector(25, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));
		world.register(new Block(new Box(new Vector(25, -13), new Vector(26, 31)), world.getLoader().getSprite("castle.center"), 44, "Y"));

        
        
	}

}
