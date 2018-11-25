package platform.game.level;

import platform.game.*;
import platform.util.*;

public class DoubleJumpLevel extends Level{

	@Override
    public void register(World world) {
        super.register(world);
        
        // Register a new instance, to restart level automatically
        world.setNextLevel(new DoubleJumpLevel());
        
        // Create blocks
        Player player = new Player(new Vector(-6,-1.5), new Vector(0,0), 6.0, 6.0);
        world.register(player);
        world.register(new Overlay(player));
        
        world.register(new Background(new Vector(-25,-12), 64, 36, "space"));
        
        //Blocks
        world.register(new Block(new Box(new Vector(-8, -3), new Vector(-4, -2)), world.getLoader().getSprite("stone.3")));
        world.register(new Block(new Box(new Vector(-7, -9), new Vector(-6, -3)), world.getLoader().getSprite("platformIndustrial_005"), 6, "Y"));
        world.register(new Block(new Box(new Vector(-23, -10), new Vector(-6, -9)), world.getLoader().getSprite("platformIndustrial_005"), 17, "X"));
        world.register(new Block(new Box(new Vector(-23, -13), new Vector(-22, -6)), world.getLoader().getSprite("platformIndustrial_005"), 7, "Y"));
        world.register(new Block(new Box(new Vector(-24, -13), new Vector(-22, -12)), world.getLoader().getSprite("platformIndustrial_005"), 2, "X"));
        world.register(new Block(new Box(new Vector(-29, -13), new Vector(-26, -12)), world.getLoader().getSprite("platformIndustrial_005"), 3, "X"));
        world.register(new Block(new Box(new Vector(-33, -13), new Vector(-31, -12)), world.getLoader().getSprite("platformIndustrial_005"), 2, "X"));
        world.register(new Block(new Box(new Vector(-33, -13), new Vector(-32, -1)), world.getLoader().getSprite("platformIndustrial_005"), 12, "Y"));
        world.register(new Block(new Box(new Vector(-33, -2), new Vector(-23, -1)), world.getLoader().getSprite("platformIndustrial_005"), 10, "X"));
        world.register(new Block(new Box(new Vector(-23, -3), new Vector(-21, -1)), world.getLoader().getSprite("stone.4")));
        world.register(new Block(new Box(new Vector(-22, -1), new Vector(-21, 4)), world.getLoader().getSprite("platformIndustrial_005"), 5, "Y"));
        world.register(new Block(new Box(new Vector(-22, 3), new Vector(-4, 4)), world.getLoader().getSprite("platformIndustrial_005"), 18, "X"));
        world.register(new Block(new Box(new Vector(-43, -9), new Vector(-33, -8)), world.getLoader().getSprite("platformIndustrial_005"), 10, "X"));
        world.register(new Block(new Box(new Vector(-43, -15), new Vector(-42, -8)), world.getLoader().getSprite("platformIndustrial_005"), 7, "Y"));
        world.register(new Block(new Box(new Vector(-46, -15), new Vector(-42, -14)), world.getLoader().getSprite("platformIndustrial_005"), 4, "X"));
        world.register(new Block(new Box(new Vector(-46, -18), new Vector(-45, -14)), world.getLoader().getSprite("platformIndustrial_005"), 4, "Y"));
        world.register(new Block(new Box(new Vector(-46, -18), new Vector(-42, -17)), world.getLoader().getSprite("platformIndustrial_005"), 4, "X"));
        world.register(new Block(new Box(new Vector(-43, -19), new Vector(-19, -18)), world.getLoader().getSprite("platformIndustrial_005"), 24, "X"));
        world.register(new Block(new Box(new Vector(-11, -26), new Vector(-10, -21)), world.getLoader().getSprite("platformIndustrial_005"), 5, "Y"));
        world.register(new Block(new Box(new Vector(-22, -24), new Vector(-10, -23)), world.getLoader().getSprite("platformIndustrial_005"), 12, "X"));
        world.register(new Block(new Box(new Vector(-22, -24), new Vector(-21, -19)), world.getLoader().getSprite("platformIndustrial_005"), 5, "Y"));
        world.register(new Block(new Box(new Vector(-11, -26), new Vector(-3, -25)), world.getLoader().getSprite("platformIndustrial_005"), 8, "X"));
        world.register(new Block(new Box(new Vector(-8.5, -24), new Vector(-7.5, -21)), world.getLoader().getSprite("platformIndustrial_005"), 3, "Y"));
        world.register(new Block(new Box(new Vector(-8, -22), new Vector(-3, -21)), world.getLoader().getSprite("platformIndustrial_005"), 5, "X"));
        world.register(new Block(new Box(new Vector(-21, -30), new Vector(-16, -29)), world.getLoader().getSprite("platformIndustrial_005"), 5, "X"));
        world.register(new Block(new Box(new Vector(-33, -30), new Vector(-30, -29)), world.getLoader().getSprite("platformIndustrial_005"), 3, "X"));

        
        //Jumpers
        world.register(new Jumper(new Vector(-20.5, -17.5)));

        
        //Signals
        Lever leverDJ1 = new Lever(new Box(new Vector(-6.5, -1.5), 1, 1), 5.0);
        world.register(leverDJ1);
        
        Torch torchDJ1 = new Torch(new Vector(-27.5, -5.5), false);
        world.register(torchDJ1);
        Torch torchDJ2 = new Torch(new Vector(-15.5, -11.5), false);
        world.register(torchDJ2);
        Torch torchDJ3 = new Torch(new Vector(-3.5, -11.5), false);
        world.register(torchDJ3);
        Torch torchDJ4 = new Torch(new Vector(-6.5, -23.5), false);
        world.register(torchDJ4);
        
        
        //Spikes
        world.register(new Spike(new Vector(-7.5, -9)));
        world.register(new Spike(new Vector(-8.5, -9)));
        world.register(new Spike(new Vector(-9.5, -9)));
        world.register(new Spike(new Vector(-10.5, -9)));
        world.register(new Spike(new Vector(-11.5, -9)));
        world.register(new Spike(new Vector(-12.5, -9)));
        world.register(new Spike(new Vector(-13.5, -9)));
        world.register(new Spike(new Vector(-14.5, -9)));
        world.register(new Spike(new Vector(-15.5, -9)));
        world.register(new Spike(new Vector(-16.5, -9)));
        world.register(new Spike(new Vector(-17.5, -9)));
        world.register(new Spike(new Vector(-18.5, -9)));
        world.register(new Spike(new Vector(-19.5, -9)));
        world.register(new Spike(new Vector(-20.5, -9)));
        world.register(new Spike(new Vector(-21.5, -9)));
        
        world.register(new Spike(new Vector(-20.5, -23)));
        world.register(new Spike(new Vector(-19.5, -23)));
        world.register(new Spike(new Vector(-18.5, -23)));
        world.register(new Spike(new Vector(-17.5, -23)));
        world.register(new Spike(new Vector(-16.5, -23)));
        world.register(new Spike(new Vector(-15.5, -23)));
        world.register(new Spike(new Vector(-14.5, -23)));
        world.register(new Spike(new Vector(-13.5, -23)));
        world.register(new Spike(new Vector(-12.5, -23)));
        world.register(new Spike(new Vector(-11.5, -23)));

        
        //Movers
        world.register(new Mover(new Box(new Vector(-21, -6), new Vector(-18, -5)), world.getLoader().getSprite("stone.broken.2"), leverDJ1, new Vector(-19, -5), new Vector(-10, -5), 2));
        world.register(new Mover(new Box(new Vector(-31, -13), new Vector(-29, -12)), world.getLoader().getSprite("stone.broken.2"), torchDJ1, new Vector(-30, -12.5), new Vector(-30, -18.5), 1));
        world.register(new Mover(new Box(new Vector(-25, -12.5), 2, 1), world.getLoader().getSprite("stone.2"), torchDJ1, new Vector(-25, -12.5), new Vector(-25, -18.5), 1));
        world.register(new Mover(new Box(new Vector(-18, -13.5), 2, 1), world.getLoader().getSprite("stone.2"), torchDJ2, new Vector(-18, -13.5), new Vector(-10, -13.5), 1.5));
        world.register(new Mover(new Box(new Vector(-6, -13.5), 2, 1), world.getLoader().getSprite("stone.2"), torchDJ3, new Vector(-6, -13.5), new Vector(-6, -18.5), 1.5));
        world.register(new Mover(new Box(new Vector(-3.5, -23.5), 1, 3), world.getLoader().getSprite("stone.2"), torchDJ4, new Vector(-3.5, -23.5), new Vector(-3.5, -20), 0.4));
        world.register(new Mover(new Box(new Vector(5, -28), 2, 1), world.getLoader().getSprite("stone.2"), torchDJ4, new Vector(5, -28), new Vector(-14, -28), 4));
        
        //Portals
        world.register(new Portal(new Vector(-31.5, -26), new Vector(0, 1), 2, 2));
        
        //Upgrades
        world.register(new Upgrade(new Vector(-18.5, -28), Upgrade.DOUBLEJUMPUPGRADE));
        
        world.register(new Limits(new Box(Vector.ZERO, 100, 60)));
       
        //world.register(new Heart(new Vector(-0.5,4.5), 10));
        
        //world.register(new Torch(new Vector(4, 3), true));
        
        //world.register(new Spike(new Vector(1.5,2)));
    }
}
