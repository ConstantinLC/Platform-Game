package platform.game.level;

import platform.game.World;
import platform.game.Block;
import platform.game.Heart;
import platform.game.Jumper;
import platform.game.Limits;
import platform.game.Overlay;
import platform.game.Player;
import platform.game.Spike;
import platform.game.Torch;
import platform.util.Box;
import platform.util.Vector;

public class BasicInteract extends Level {
    @Override
    public void register(World world) {
        super.register(world);
        
        // Register a new instance, to restart level automatically
        world.setNextLevel(new BasicInteract());
        
        // Create blocks
        Player player = new Player(new Vector(3,2), new Vector(0,0), 6.0, 6.0);
        world.register(player);
        world.register(new Overlay(player));
        
        world.register(new Block(new Box(new Vector(0, 0), new Vector(4, 2)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(-2, 0), new Vector(0, 4)), world.getLoader().getSprite("stone.broken.8")));
        
        world.register(new Jumper(new Vector(0.5,2.5)));
       
        world.register(new Limits(new Box(Vector.ZERO, 40, 30)));
       
        world.register(new Heart(new Vector(-0.5,4.5), 10));
        
        world.register(new Torch(new Vector(4, 3), true));
        
        world.register(new Spike(new Vector(1.5,2)));
    }
    
}
