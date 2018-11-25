package platform.game.level;

import platform.game.And;
import platform.game.Background;
import platform.game.Block;
import platform.game.Clock;
import platform.game.ExistenceOf;
import platform.game.FireballGenerator;
import platform.game.Jumper;
import platform.game.JumperMover;
import platform.game.Key;
import platform.game.Lava;
import platform.game.Lever;
import platform.game.Limits;
import platform.game.Mover;
import platform.game.Not;
import platform.game.Overlay;
import platform.game.Player;
import platform.game.Portal;
import platform.game.SawBladeGenerator;
import platform.game.SlimeBoss;
import platform.game.Spike;
import platform.game.SpikeMover;
import platform.game.Torch;
import platform.game.Upgrade;
import platform.game.WoodenBox;
import platform.game.World;
import platform.util.Box;
import platform.util.Vector;

import platform.game.*;

public class LevelOne extends Level{

	public void register(World world) {
		super.register(world);

		// Register a new instance, to restart level automatically
		world.setNextLevel(new LevelOne());

		// Create blocks
		Player player = new Player(new Vector(0, 0), new Vector(0,0), 6.0, 6.0, true);
		world.register(player);

		world.register(new Overlay(player));
		
		world.register(new Jumper(new Vector(6.5, 13.5)));

		world.register(new Limits(new Box(new Vector(0,0), 150, 135)));
		world.register(new Block(new Box(new Vector(5, 7), new Vector(9, 8)), world.getLoader().getSprite("ScifiTile"), 4, "X"));
		world.register(new Block(new Box(new Vector(5, 12), new Vector(9, 13)), world.getLoader().getSprite("ScifiTile"), 4, "X"));
		world.register(new Block(new Box(new Vector(9, 6), new Vector(56, 7)), world.getLoader().getSprite("ScifiTile"), 47, "X"));
		world.register(new Block(new Box(new Vector(11, 13), new Vector(56, 14)), world.getLoader().getSprite("ScifiTile"), 45, "X"));
		world.register(new Block(new Box(new Vector(13, 8), new Vector(16, 9)), world.getLoader().getSprite("ScifiTile"), 3, "X"));
		world.register(new Block(new Box(new Vector(19, 8), new Vector(22, 9)), world.getLoader().getSprite("ScifiTile"), 3, "X"));
		world.register(new Block(new Box(new Vector(26, 8), new Vector(27, 9)), world.getLoader().getSprite("ScifiTile"), 1, "X"));
		world.register(new Block(new Box(new Vector(31, 8), new Vector(33, 9)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(39, 8), new Vector(40, 9)), world.getLoader().getSprite("ScifiTile"), 1, "X"));
		world.register(new Block(new Box(new Vector(44, 8), new Vector(47, 9)), world.getLoader().getSprite("ScifiTile"), 3, "X"));
		world.register(new Block(new Box(new Vector(55, 6), new Vector(56, 14)), world.getLoader().getSprite("ScifiTile"), 8, "Y"));
		world.register(new Block(new Box(new Vector(49, 8), new Vector(51, 9)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(8, 16), new Vector(10, 17)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(14, 19), new Vector(16, 20)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(20, 19), new Vector(22, 20)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(27, 18), new Vector(29, 19)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(35, 18), new Vector(36, 19)), world.getLoader().getSprite("ScifiTile"), 1, "X"));
		world.register(new Block(new Box(new Vector(42, 18), new Vector(44, 19)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(53.5, 16.5), new Vector(54.5, 17.5)), world.getLoader().getSprite("ScifiTile"), 1, "X"));
		world.register(new Block(new Box(new Vector(5, 12), new Vector(6, 42)), world.getLoader().getSprite("ScifiTile"), 30, "Y"));
		world.register(new Block(new Box(new Vector(5, 42), new Vector(55, 43)), world.getLoader().getSprite("ScifiTile"),50, "X"));
		world.register(new Block(new Box(new Vector(55, -20), new Vector(56, 43)), world.getLoader().getSprite("ScifiTile"),63, "Y"));



		world.register(new WoodenBox(new Vector(51.5, 10), 1));
		world.register(new WoodenBox(new Vector(53.5, 10), 1));
		world.register(new WoodenBox(new Vector(52.5, 10), 1));
		world.register(new WoodenBox(new Vector(52.5, 9), 1));
		world.register(new WoodenBox(new Vector(53.5, 9), 1));
		world.register(new WoodenBox(new Vector(51.5, 9), 1));
		world.register(new WoodenBox(new Vector(52.5, 8), 1));
		world.register(new WoodenBox(new Vector(53.5, 8), 1));
		world.register(new WoodenBox(new Vector(51.5, 8), 1));
		world.register(new WoodenBox(new Vector(51.5, 11), 1));
		world.register(new WoodenBox(new Vector(52.5, 11), 1));
		world.register(new WoodenBox(new Vector(53.5, 11), 1));
		world.register(new WoodenBox(new Vector(51.5, 12), 1));
		world.register(new WoodenBox(new Vector(53.5, 12), 1));
		world.register(new WoodenBox(new Vector(52.5, 12), 1));


		Torch torchGS1 = new Torch(new Vector(54.5, 9), false);
		world.register(torchGS1);

		Clock clockGS1 = new Clock(3);
		world.register(clockGS1);

		Lever leverGS1 = new Lever(new Box(new Vector(54, 18), 1, 1));
		world.register(leverGS1);

		And andGS1 = new And(clockGS1, torchGS1);

		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 1)), world.getLoader().getSprite("stone.broken.2"), andGS1, new Vector(10, 13.5), new Vector(13, 13), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 1)), world.getLoader().getSprite("stone.broken.2"), new And(leverGS1, new Not(clockGS1)), new Vector(48, 17), new Vector(48, 30), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 4)), world.getLoader().getSprite("stone.broken.8"), andGS1, new Vector(18, 19), new Vector(18, 24), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 4)), world.getLoader().getSprite("stone.broken.8"), andGS1, new Vector(25, 18), new Vector(25, 24), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 4)), world.getLoader().getSprite("stone.broken.8"), andGS1, new Vector(32, 19), new Vector(32, 24), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 4)), world.getLoader().getSprite("stone.broken.8"), andGS1, new Vector(39.5, 19.5), new Vector(39.5, 25), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 4)), world.getLoader().getSprite("stone.broken.8"), andGS1, new Vector(51.5, 19), new Vector(51.5, 26), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 1)), world.getLoader().getSprite("stone.broken.2"), new And(leverGS1, clockGS1), new Vector(46, 28), new Vector(43, 29), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 1)), world.getLoader().getSprite("stone.broken.2"), new And(leverGS1, new Not(clockGS1)), new Vector(39, 29), new Vector(34, 29), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 1)), world.getLoader().getSprite("stone.broken.2"), new And(leverGS1, clockGS1), new Vector(31, 28), new Vector(24, 29), 3.0));
		world.register(new Mover(new Box(new Vector(0, 0), new Vector(2, 1)), world.getLoader().getSprite("stone.broken.2"), new And(leverGS1, new Not(clockGS1)), new Vector(21, 28), new Vector(16,35), 3.0));

		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(17.5,16.75), new Vector(17.5,21.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(18.5,16.75), new Vector(18.5,21.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(24.5,15.75), new Vector(24.5,21.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(25.5,15.75), new Vector(25.5,21.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(31.5,16.75), new Vector(31.5,21.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(32.5,16.75), new Vector(32.5,21.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(39,17.25), new Vector(39,22.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(40,17.25), new Vector(40,22.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(51,16.75), new Vector(51,23.75), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), Math.PI, andGS1, new Vector(52,16.75), new Vector(52,23.75), 3.0));

		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(17.5, 21.25), new Vector(17.5, 26.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(18.5, 21.25), new Vector(18.5, 26.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(24.5, 20.25), new Vector(24.5, 26.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(25.5, 20.25), new Vector(25.5,26.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(31.5, 21.25), new Vector(31.5,26.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(32.5, 21.25), new Vector(32.5,26.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(39,21.75), new Vector(39,27.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(40,21.75), new Vector(40,27.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(51,21.25), new Vector(51,28.25), 3.0));
		world.register(new SpikeMover(new Vector(20, 20), 0, andGS1, new Vector(52,21.25), new Vector(52,28.25), 3.0));

		world.register(new Upgrade(new Vector(17, 37), 4));

		world.register(new SawBladeGenerator(new Vector(25, 38), player, 10, 30));
		world.register(new SawBladeGenerator(new Vector(35, 38), player, 10, 30));
		world.register(new SawBladeGenerator(new Vector(45, 38), player, 10, 30));

		world.register(new Spike(new Vector(11.5, 14), 0));
		world.register(new Spike(new Vector(12.5, 14), 0));
		world.register(new Spike(new Vector(13.5, 14), 0));
		world.register(new Spike(new Vector(14.5, 14), 0));
		world.register(new Spike(new Vector(15.5, 14), 0));
		world.register(new Spike(new Vector(16.5, 14), 0));
		world.register(new Spike(new Vector(17.5, 14), 0));
		world.register(new Spike(new Vector(18.5, 14), 0));
		world.register(new Spike(new Vector(19.5, 14), 0));
		world.register(new Spike(new Vector(20.5, 14), 0));
		world.register(new Spike(new Vector(21.5, 14), 0));
		world.register(new Spike(new Vector(22.5, 14), 0));
		world.register(new Spike(new Vector(23.5, 14), 0));
		world.register(new Spike(new Vector(24.5, 14), 0));
		world.register(new Spike(new Vector(25.5, 14), 0));
		world.register(new Spike(new Vector(26.5, 14), 0));
		world.register(new Spike(new Vector(27.5, 14), 0));
		world.register(new Spike(new Vector(28.5, 14), 0));
		world.register(new Spike(new Vector(29.5, 14), 0));
		world.register(new Spike(new Vector(30.5, 14), 0));
		world.register(new Spike(new Vector(31.5, 14), 0));
		world.register(new Spike(new Vector(32.5, 14), 0));
		world.register(new Spike(new Vector(33.5, 14), 0));
		world.register(new Spike(new Vector(34.5, 14), 0));
		world.register(new Spike(new Vector(35.5, 14), 0));
		world.register(new Spike(new Vector(36.5, 14), 0));
		world.register(new Spike(new Vector(37.5, 14), 0));
		world.register(new Spike(new Vector(38.5, 14), 0));
		world.register(new Spike(new Vector(39.5, 14), 0));
		world.register(new Spike(new Vector(40.5, 14), 0));
		world.register(new Spike(new Vector(41.5, 14), 0));
		world.register(new Spike(new Vector(42.5, 14), 0));
		world.register(new Spike(new Vector(43.5, 14), 0));
		world.register(new Spike(new Vector(44.5, 14), 0));
		world.register(new Spike(new Vector(45.5, 14), 0));
		world.register(new Spike(new Vector(46.5, 14), 0));
		world.register(new Spike(new Vector(47.5, 14), 0));
		world.register(new Spike(new Vector(48.5, 14), 0));
		world.register(new Spike(new Vector(49.5, 14), 0));
		world.register(new Spike(new Vector(50.5, 14), 0));
		world.register(new Spike(new Vector(51.5, 14), 0));
		world.register(new Spike(new Vector(52.5, 14), 0));
		world.register(new Spike(new Vector(53.5, 14), 0));
		world.register(new Spike(new Vector(54.5, 14), 0));

		world.register(new Lava(new Vector(9.5, 7.5)));
		world.register(new Lava(new Vector(10.5, 7.5)));
		world.register(new Lava(new Vector(11.5, 7.5)));
		world.register(new Lava(new Vector(12.5, 7.5)));
		world.register(new Lava(new Vector(13.5, 7.5)));
		world.register(new Lava(new Vector(14.5, 7.5)));
		world.register(new Lava(new Vector(15.5, 7.5)));
		world.register(new Lava(new Vector(16.5, 7.5)));
		world.register(new Lava(new Vector(17.5, 7.5)));
		world.register(new Lava(new Vector(18.5, 7.5)));
		world.register(new Lava(new Vector(19.5, 7.5)));
		world.register(new Lava(new Vector(20.5, 7.5)));
		world.register(new Lava(new Vector(21.5, 7.5)));
		world.register(new Lava(new Vector(22.5, 7.5)));
		world.register(new Lava(new Vector(23.5, 7.5)));
		world.register(new Lava(new Vector(24.5, 7.5)));
		world.register(new Lava(new Vector(25.5, 7.5)));
		world.register(new Lava(new Vector(26.5, 7.5)));
		world.register(new Lava(new Vector(27.5, 7.5)));
		world.register(new Lava(new Vector(28.5, 7.5)));
		world.register(new Lava(new Vector(29.5, 7.5)));
		world.register(new Lava(new Vector(30.5, 7.5)));
		world.register(new Lava(new Vector(31.5, 7.5)));
		world.register(new Lava(new Vector(32.5, 7.5)));
		world.register(new Lava(new Vector(33.5, 7.5)));
		world.register(new Lava(new Vector(34.5, 7.5)));
		world.register(new Lava(new Vector(35.5, 7.5)));
		world.register(new Lava(new Vector(36.5, 7.5)));
		world.register(new Lava(new Vector(37.5, 7.5)));
		world.register(new Lava(new Vector(38.5, 7.5)));
		world.register(new Lava(new Vector(39.5, 7.5)));
		world.register(new Lava(new Vector(40.5, 7.5)));
		world.register(new Lava(new Vector(41.5, 7.5)));
		world.register(new Lava(new Vector(42.5, 7.5)));
		world.register(new Lava(new Vector(43.5, 7.5)));
		world.register(new Lava(new Vector(44.5, 7.5)));
		world.register(new Lava(new Vector(45.5, 7.5)));
		world.register(new Lava(new Vector(46.5, 7.5)));
		world.register(new Lava(new Vector(47.5, 7.5)));
		world.register(new Lava(new Vector(48.5, 7.5)));
		world.register(new Lava(new Vector(49.5, 7.5)));
		world.register(new Lava(new Vector(50.5, 7.5)));
		world.register(new Lava(new Vector(51.5, 7.5)));
		world.register(new Lava(new Vector(52.5, 7.5)));
		world.register(new Lava(new Vector(53.5, 7.5)));
		world.register(new Lava(new Vector(54.5, 7.5)));

		world.register(new FireballGenerator(new Vector(11.5, 7.5), 4));
		world.register(new FireballGenerator(new Vector(17.5, 7.5), 5));
		world.register(new FireballGenerator(new Vector(23.5, 7.5), 6));
		world.register(new FireballGenerator(new Vector(29.5, 7.5), 5));
		world.register(new FireballGenerator(new Vector(35.5, 7.5), 3));
		
		// Create blocks
        world.register(new Overlay(player));
        
        
        //blocks
        world.register(new Block(new Box(new Vector(-6, 8), new Vector(-4, 9)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(-27, 19), new Vector(-21, 20)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(-32, 33), new Vector(-28, 34)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(-65, 44), new Vector(-45, 45)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(-45, 44), new Vector(-44, 65)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(-65, 64), new Vector(-45, 65)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(-65, 47), new Vector(-64, 65)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(-70, 47), new Vector(-64, 48)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(-70, 44), new Vector(-64, 45)), world.getLoader().getSprite("ScifiTile")));

        //Wooden boxes
        world.register(new WoodenBox(new Vector(-69.5, 45.5), 1));
        world.register(new WoodenBox(new Vector(-69.5, 46.5), 1));
        
        
        //signals
        Torch torchB1 = new Torch(new Vector(-28.5, 36), false);
        world.register(torchB1);
        ExistenceOf slimeBossExistence = new ExistenceOf(SlimeBoss.class);
        world.register(slimeBossExistence);
        
        //Movers
        world.register(new Mover(new Box(new Vector(-26, 33), new Vector(-24, 34)), world.getLoader().getSprite("stone.broken.2"), new And(torchB1, clockGS1), new Vector(-25, 33.5), new Vector(-25, 45), 2));
        world.register(new Mover(new Box(new Vector(-65, 45), new Vector(-64, 47)), world.getLoader().getSprite("stone.broken.2"), new Not(slimeBossExistence), new Vector(-64.5, 46), new Vector(-64.5, 50), 1));

        
        //Portals
        world.register(new Portal(new Vector(-5, 10), new Vector(-22, 21), 2, 2));
        world.register(new Portal(new Vector(-30, 21), new Vector(-45, 30), 2, 2));
        world.register(new Portal(new Vector(-45, 22), new Vector(-30, 35), 2, 2));
        world.register(new Portal(new Vector(-48, 21), new Vector(-55, 30), 2, 2));
        world.register(new Portal(new Vector(-55, 20), new Vector(-45, 30), 2, 2));
        world.register(new Portal(new Vector(-35, 45), new Vector(-40, 55), 2, 2));
        world.register(new Portal(new Vector(-40, 45), new Vector(-48, 47), 2, 2));
        world.register(new Portal(new Vector(-67.5, 50), new Vector(0, 1), 2, 2));

        
        //SlimeBoss
        world.register(new SlimeBoss(new Vector(-60, 50), 12, 6, false, 8));
        
        //Upgrades
        world.register(new Upgrade(new Vector(-67, 46), Upgrade.BOMBUPGRADE));
        

        world.register(new Block(new Box(new Vector(5, 0), new Vector(7, 1)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(10, -2), new Vector(11, -1)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(20, -5), new Vector(22, -4)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(5, -9), new Vector(23, -8)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(23, -10), new Vector(25, -9)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(23, 0), new Vector(25, 1)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(25, -11), new Vector(26, -10)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Block(new Box(new Vector(29, -5), new Vector(31, -4)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(26, -13), new Vector(27, -9)), world.getLoader().getSprite("stone.broken.8")));
        world.register(new Block(new Box(new Vector(29, -13), new Vector(30, -9)), world.getLoader().getSprite("stone.broken.8")));
        world.register(new Block(new Box(new Vector(32, -13), new Vector(33, -9)), world.getLoader().getSprite("stone.broken.8")));
        world.register(new Block(new Box(new Vector(26, -13), new Vector(30, -12)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(29, -13), new Vector(33, -12)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(34, -4), new Vector(36, -3)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(33, -13), new Vector(41, -12)), world.getLoader().getSprite("stone.broken.2")));
       //MOVER world.register(new Block(new Box(new Vector(41, -14), new Vector(43, -13)), world.getLoader().getSprite("stone.broken.2"))); //MOVER
        world.register(new Block(new Box(new Vector(43, -15), new Vector(46, -14)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(35, -17.5), new Vector(36, -16.5)), world.getLoader().getSprite("ScifiTile")));
        world.register(new Jumper(new Vector(40.5, -21.5)));
        world.register(new Jumper(new Vector(31.5, -22.5)));
        world.register(new Block(new Box(new Vector(25, -19), new Vector(26, -18)), world.getLoader().getSprite("ScifiTile")));
        
        world.register(new Spike(new Vector(5.5, -8), 0));
        world.register(new Spike(new Vector(6.5, -8), 0));
        world.register(new Spike(new Vector(7.5, -8), 0));
        world.register(new Spike(new Vector(8.5, -8), 0));
        world.register(new Spike(new Vector(9.5, -8), 0));
        world.register(new Spike(new Vector(10.5, -8), 0));
        world.register(new Spike(new Vector(11.5, -8), 0));
        world.register(new Spike(new Vector(12.5, -8), 0));
        world.register(new Spike(new Vector(13.5, -8), 0));
        world.register(new Spike(new Vector(14.5, -8), 0));
        world.register(new Spike(new Vector(15.5, -8), 0));
        world.register(new Spike(new Vector(16.5, -8), 0));
        world.register(new Spike(new Vector(17.5, -8), 0));
        world.register(new Spike(new Vector(18.5, -8), 0));
        world.register(new Spike(new Vector(19.5, -8), 0));
        world.register(new Spike(new Vector(20.5, -8), 0));
        world.register(new Spike(new Vector(21.5, -8), 0));
        world.register(new Spike(new Vector(22.5, -8), 0));

        world.register(new Spike(new Vector(23.5, -9), 0));
        world.register(new Spike(new Vector(24.5, -9), 0));

        world.register(new Spike(new Vector(25.5, -10), 0));

        world.register(new Spike(new Vector(23.5, -0.5), Math.PI));
        world.register(new Spike(new Vector(24.5, -0.5), Math.PI));

        world.register(new Spike(new Vector(30.5, -5.5), Math.PI));
        world.register(new Spike(new Vector(29.5, -5.5), Math.PI));

        world.register(new Spike(new Vector(34.5, -4.5), Math.PI));
        world.register(new Spike(new Vector(35.5, -4.5), Math.PI));
        
        world.register(new WoodenBox(new Vector(39.5, -2.5), 1));
        world.register(new WoodenBox(new Vector(40.5, -2.5), 1));
        world.register(new WoodenBox(new Vector(41.5, -2.5), 1));
        world.register(new WoodenBox(new Vector(42.5, -2.5), 1));
        world.register(new WoodenBox(new Vector(43.5, -2.5), 1));
        world.register(new WoodenBox(new Vector(40.5, -3.5), 1));
        world.register(new WoodenBox(new Vector(41.5, -3.5), 1));
        world.register(new WoodenBox(new Vector(43.5, -3.5), 1));
        world.register(new WoodenBox(new Vector(42.5, -3.5), 1));
        world.register(new WoodenBox(new Vector(39.5, -1.5), 1));
        world.register(new WoodenBox(new Vector(40.5, -1.5), 1));
        world.register(new WoodenBox(new Vector(41.5, -1.5), 1));
        world.register(new WoodenBox(new Vector(42.5, -1.5), 1));
        world.register(new WoodenBox(new Vector(43.5, -1.5), 1));
        world.register(new WoodenBox(new Vector(38.5, -1.5), 1));
        world.register(new WoodenBox(new Vector(40.5, -0.5), 1));
        world.register(new WoodenBox(new Vector(41.5, -0.5), 1));
        world.register(new WoodenBox(new Vector(43.5, -0.5), 1));
        world.register(new WoodenBox(new Vector(42.5, -0.5), 1));
        world.register(new WoodenBox(new Vector(39.5, -0.5), 1));
        world.register(new WoodenBox(new Vector(40.5, 0.5), 1));
        world.register(new WoodenBox(new Vector(41.5, 0.5), 1));
        world.register(new WoodenBox(new Vector(43.5, 0.5), 1));
        world.register(new WoodenBox(new Vector(42.5, 0.5), 1));
        
        world.register(new Block(new Box(new Vector(44, 0), new Vector(48, 1)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(44, -4), new Vector(48, -3)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(48, -4), new Vector(49, 1)), world.getLoader().getSprite("stone.broken.8")));
        world.register(new Block(new Box(new Vector(49, -4), new Vector(51, -3)), world.getLoader().getSprite("stone.broken.2")));
        
        world.register(new Background(new Vector(-62,0), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26,0), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10,0), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46,0), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10,18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46,18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10,-18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46,-18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26,18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26,0), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26,-18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26,-36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10,-36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46,-36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10,36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46,36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26,36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26,54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10,54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46,54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62,18),36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62,36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62, -18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62, 54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62, -36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, -54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62, -54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26, -54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10, -54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46, -54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, -54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, -36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, -18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, 0), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, 18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, 36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, 54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, 54), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, 36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, 18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, 0), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, -18), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, -36), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, 72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62, 72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26, 72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10, 72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46, 72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, 72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62, -72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-98, -72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-62, -72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(-26, -72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(10, -72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(46, -72), 36, 18, "ScifiBackground"));
        world.register(new Background(new Vector(82, -72), 36, 18, "ScifiBackground"));

        world.register(new Overlay(player));
        
        Lever leverFB1 = new Lever(new Box(new Vector(25, -18), new Vector(26, -17)), 5);
        world.register(leverFB1);
        
        Lever leverFB2 = new Lever(new Box(new Vector(49, -3), new Vector (50, -2)));
        world.register(leverFB2);
        
        Mover moverFB1 = new Mover(new Box(new Vector(25, -18), new Vector(28, -17)), world.getLoader().getSprite("stone.broken.2"), leverFB1, new Vector(43, -20), new Vector(13, -20), 5);
        world.register(moverFB1);
        
        Clock s1 = new Clock(2);
        world.register(s1);
        
        Mover moverFB2 = new Mover(new Box(new Vector(18, 2), new Vector(19, 4)), world.getLoader().getSprite("stone.broken.8"), s1, new Vector(24, -2), new Vector(24, -6), 2);
        world.register(moverFB2);
        
        Mover moverFB3 = new Mover(new Box(new Vector(18, 2), new Vector(20, 3)), world.getLoader().getSprite("stone.broken.2"), leverFB2, new Vector(42, -13.5), new Vector(40, -13.5), 2);
        world.register(moverFB3);
        
        JumperMover jumperMoverFB1 = new JumperMover(s1, new Vector(24, -0.5), new Vector(24, -4.5), 2, 0);
        world.register(jumperMoverFB1);
        
        world.register(new Jumper(new Vector(52, -8)));
        world.register(new Block(new Box(new Vector(51.5, -9.5), new Vector(52.5, -8.5)), world.getLoader().getSprite("ScifiTile")));
        
        world.register(new Jumper(new Vector(48, -13)));
        world.register(new Block(new Box(new Vector(47.5, -14.5), new Vector(48.5, -13.5)), world.getLoader().getSprite("ScifiTile")));
        
        world.register(new Block(new Box(new Vector(40, -23), new Vector(41, -22)), world.getLoader().getSprite("ScifiTile")));
        
        world.register(new Block(new Box(new Vector(31, -24), new Vector(32, -23)), world.getLoader().getSprite("ScifiTile")));
        
        world.register(new Spike(new Vector(24.75, -18.75), Math.PI/2));
        world.register(new Spike(new Vector(25.5, -19.5), Math.PI));
        world.register(new Spike(new Vector(26.25, -18.75), 3*Math.PI/2));
        
        world.register(new Spike(new Vector(34.75, -17.25), Math.PI/2));
        world.register(new Spike(new Vector(35.5, -18), Math.PI));
        world.register(new Spike(new Vector(36.25, -17.25), 3*Math.PI/2));
        
        world.register(new Spike(new Vector(47.5, -4.5), Math.PI));
        world.register(new Spike(new Vector(48.5, -4.5), Math.PI));
        world.register(new Spike(new Vector(49.5, -4.5), Math.PI));
        world.register(new Spike(new Vector(46.5, -4.5), Math.PI));
        world.register(new Spike(new Vector(45.5, -4.5), Math.PI));
        world.register(new Spike(new Vector(44.5, -4.5), Math.PI));
        world.register(new Spike(new Vector(50.5, -4.5), Math.PI));
        
        world.register(new Block(new Box(new Vector(8, -20), new Vector(10, -19)), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(6, -19), new Vector(8, -18)), world.getLoader().getSprite("stone.broken.2")));
        
        Torch torchFB1 = new Torch(new Vector(2, -17), false);
        Clock clockFB2 = new Clock(4);
        world.register(torchFB1);
        world.register(clockFB2);
        
        And andFB1 = new And(torchFB1, clockFB2);

        Mover moverFB4 = new Mover(new Box(new Vector(4, -11), new Vector(6, -10)), world.getLoader().getSprite("stone.broken.8"), andFB1, new Vector(4, -8.5), new Vector(4, -20), 4);
        world.register(moverFB4);
        
        world.register(new Upgrade(new Vector(8, -17), 1));
        

		//Blocks
		world.register(new Block(new Box(new Vector(-8, -3), new Vector(-4, -2)), world.getLoader().getSprite("stone.3")));
		world.register(new Block(new Box(new Vector(-7, -9), new Vector(-6, -3)), world.getLoader().getSprite("ScifiTile"), 6, "Y"));
		world.register(new Block(new Box(new Vector(-23, -10), new Vector(-6, -9)), world.getLoader().getSprite("ScifiTile"), 17, "X"));
		world.register(new Block(new Box(new Vector(-23, -13), new Vector(-22, -6)), world.getLoader().getSprite("ScifiTile"), 7, "Y"));
		world.register(new Block(new Box(new Vector(-24, -13), new Vector(-22, -12)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(-29, -13), new Vector(-26, -12)), world.getLoader().getSprite("ScifiTile"), 3, "X"));
		world.register(new Block(new Box(new Vector(-33, -13), new Vector(-31, -12)), world.getLoader().getSprite("ScifiTile"), 2, "X"));
		world.register(new Block(new Box(new Vector(-33, -13), new Vector(-32, -1)), world.getLoader().getSprite("ScifiTile"), 12, "Y"));
		world.register(new Block(new Box(new Vector(-33, -2), new Vector(-23, -1)), world.getLoader().getSprite("ScifiTile"), 10, "X"));
		world.register(new Block(new Box(new Vector(-23, -3), new Vector(-21, -1)), world.getLoader().getSprite("stone.4")));
		world.register(new Block(new Box(new Vector(-22, -1), new Vector(-21, 4)), world.getLoader().getSprite("ScifiTile"), 5, "Y"));
		world.register(new Block(new Box(new Vector(-22, 3), new Vector(-4, 4)), world.getLoader().getSprite("ScifiTile"), 18, "X"));
		world.register(new Block(new Box(new Vector(-43, -9), new Vector(-33, -8)), world.getLoader().getSprite("ScifiTile"), 10, "X"));
		world.register(new Block(new Box(new Vector(-43, -15), new Vector(-42, -8)), world.getLoader().getSprite("ScifiTile"), 7, "Y"));
		world.register(new Block(new Box(new Vector(-46, -15), new Vector(-42, -14)), world.getLoader().getSprite("ScifiTile"), 4, "X"));
		world.register(new Block(new Box(new Vector(-46, -18), new Vector(-45, -14)), world.getLoader().getSprite("ScifiTile"), 4, "Y"));
		world.register(new Block(new Box(new Vector(-46, -18), new Vector(-42, -17)), world.getLoader().getSprite("ScifiTile"), 4, "X"));
		world.register(new Block(new Box(new Vector(-43, -19), new Vector(-19, -18)), world.getLoader().getSprite("ScifiTile"), 24, "X"));
		world.register(new Block(new Box(new Vector(-11, -26), new Vector(-10, -21)), world.getLoader().getSprite("ScifiTile"), 5, "Y"));
		world.register(new Block(new Box(new Vector(-22, -24), new Vector(-10, -23)), world.getLoader().getSprite("ScifiTile"), 12, "X"));
		world.register(new Block(new Box(new Vector(-22, -24), new Vector(-21, -19)), world.getLoader().getSprite("ScifiTile"), 5, "Y"));
		world.register(new Block(new Box(new Vector(-11, -26), new Vector(-3, -25)), world.getLoader().getSprite("ScifiTile"), 8, "X"));
		world.register(new Block(new Box(new Vector(-8.5, -24), new Vector(-7.5, -21)), world.getLoader().getSprite("ScifiTile"), 3, "Y"));
		world.register(new Block(new Box(new Vector(-8, -22), new Vector(-3, -21)), world.getLoader().getSprite("ScifiTile"), 5, "X"));
		world.register(new Block(new Box(new Vector(-21, -30), new Vector(-16, -29)), world.getLoader().getSprite("ScifiTile"), 5, "X"));
		world.register(new Block(new Box(new Vector(-33, -30), new Vector(-30, -29)), world.getLoader().getSprite("ScifiTile"), 3, "X"));


		//Jumpers
		world.register(new Jumper(new Vector(-20.5, -17.5)));


		//Signals
		Lever leverDJ1 = new Lever(new Box(new Vector(-6.5, -1.5), 1, 1), Double.POSITIVE_INFINITY);
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
		world.register(new Lava(new Vector(-7.5, -8.5)));
		world.register(new Lava(new Vector(-8.5, -8.5)));
		world.register(new Lava(new Vector(-9.5, -8.5)));
		world.register(new Lava(new Vector(-10.5, -8.5)));
		world.register(new Lava(new Vector(-11.5, -8.5)));
		world.register(new Lava(new Vector(-12.5, -8.5)));
		world.register(new Lava(new Vector(-13.5, -8.5)));
		world.register(new Lava(new Vector(-14.5, -8.5)));
		world.register(new Lava(new Vector(-15.5, -8.5)));
		world.register(new Lava(new Vector(-16.5, -8.5)));
		world.register(new Lava(new Vector(-17.5, -8.5)));
		world.register(new Lava(new Vector(-18.5, -8.5)));
		world.register(new Lava(new Vector(-19.5, -8.5)));
		world.register(new Lava(new Vector(-20.5, -8.5)));
		world.register(new Lava(new Vector(-21.5, -8.5)));

		world.register(new Lava(new Vector(-20.5, -22.5)));
		world.register(new Lava(new Vector(-19.5, -22.5)));
		world.register(new Lava(new Vector(-18.5, -22.5)));
		world.register(new Lava(new Vector(-17.5, -22.5)));
		world.register(new Lava(new Vector(-16.5, -22.5)));
		world.register(new Lava(new Vector(-15.5, -22.5)));
		world.register(new Lava(new Vector(-14.5, -22.5)));
		world.register(new Lava(new Vector(-13.5, -22.5)));
		world.register(new Lava(new Vector(-12.5, -22.5)));
		world.register(new Lava(new Vector(-11.5, -22.5)));

		world.register(new Spike(new Vector(-10.5, -21),0));
		world.register(new Spike(new Vector(-8, -21),0));
		world.register(new Spike(new Vector(-7, -21),0));
		world.register(new Spike(new Vector(-6, -21),0));
		world.register(new Spike(new Vector(-5, -21),0));
		world.register(new Spike(new Vector(-4, -21),0));

		//Movers
		world.register(new Mover(new Box(new Vector(-21, -6), new Vector(-18, -5)), world.getLoader().getSprite("stone.broken.2"), new And(leverDJ1, clockGS1), new Vector(-19, -5), new Vector(-10, -5), 3));		
		world.register(new Mover(new Box(new Vector(-31, -13), new Vector(-29, -12)), world.getLoader().getSprite("stone.broken.2"), torchDJ1, new Vector(-30, -12.5), new Vector(-30, -18.5), 1));
		world.register(new Mover(new Box(new Vector(-25, -12.5), 2, 1), world.getLoader().getSprite("stone.2"), torchDJ1, new Vector(-25, -12.5), new Vector(-25, -18.5), 1));
		world.register(new Mover(new Box(new Vector(-18, -13.5), 2, 1), world.getLoader().getSprite("stone.2"), new And(torchDJ2, clockGS1), new Vector(-18, -13.5), new Vector(-10, -13.5), 1.5));
		world.register(new Mover(new Box(new Vector(-6, -13.5), 2, 1), world.getLoader().getSprite("stone.2"), new And(torchDJ3, clockGS1), new Vector(-6, -13.5), new Vector(-6, -18.5), 1.5));
		world.register(new Mover(new Box(new Vector(-3.5, -23.5), 1, 3), world.getLoader().getSprite("stone.2"), torchDJ4, new Vector(-3.5, -23.5), new Vector(-3.5, -20), 0.4));
		world.register(new Mover(new Box(new Vector(5, -28), 2, 1), world.getLoader().getSprite("stone.2"), torchDJ4, new Vector(5, -28), new Vector(-14, -28), 4));

		//Portals
		world.register(new Portal(new Vector(-31.5, -26), new Vector(0, 1), 2, 2));

		//Upgrades
		world.register(new Upgrade(new Vector(-18.5, -28), Upgrade.DOUBLEJUMPUPGRADE));

		
		world.register(new Block(new Box(new Vector(-3, -22), new Vector(-2, -2)), world.getLoader().getSprite("ScifiTile"), 20, "Y"));
		world.register(new Block(new Box(new Vector(-4, -3), new Vector(-3, -2)), world.getLoader().getSprite("ScifiTile"),1, "Y"));
		world.register(new Block(new Box(new Vector(-6, -3), new Vector(-1, -2)), world.getLoader().getSprite("ScifiTile"),5, "X"));
		world.register(new Mover(new Box(new Vector(0, 0), 2, 1), world.getLoader().getSprite("stone.2"), andFB1, new Vector(0, -2.5), new Vector(0, -7), 4));
		world.register(new Block(new Box(new Vector(1, -3), new Vector(6, -2)), world.getLoader().getSprite("ScifiTile"),5, "X"));

		world.register(new Block(new Box(new Vector(5, -2), new Vector(6, 0)), world.getLoader().getSprite("ScifiTile"),2, "Y"));
		world.register(new Block(new Box(new Vector(-5, 4), new Vector(-4, 9)), world.getLoader().getSprite("ScifiTile"),5, "Y"));
		world.register(new Block(new Box(new Vector(-5, 13), new Vector(-4, 43)), world.getLoader().getSprite("ScifiTile"),30, "Y"));
		world.register(new Block(new Box(new Vector(-5, 15), new Vector(-1, 16)), world.getLoader().getSprite("ScifiTile"),4, "X"));
		world.register(new Block(new Box(new Vector(2, 15), new Vector(6, 16)), world.getLoader().getSprite("ScifiTile"),4, "X"));
		world.register(new Block(new Box(new Vector(-5, 20), new Vector(-1, 21)), world.getLoader().getSprite("ScifiTile"),4, "X"));
		world.register(new Block(new Box(new Vector(2, 20), new Vector(6, 21)), world.getLoader().getSprite("ScifiTile"),4, "X"));
		world.register(new Block(new Box(new Vector(-5, 25), new Vector(-1, 26)), world.getLoader().getSprite("ScifiTile"),4, "X"));
		world.register(new Block(new Box(new Vector(2, 25), new Vector(6, 26)), world.getLoader().getSprite("ScifiTile"),4, "X"));
		world.register(new Block(new Box(new Vector(-5, 30), new Vector(-1, 31)), world.getLoader().getSprite("ScifiTile"),4, "X"));
		world.register(new Block(new Box(new Vector(2, 30), new Vector(6, 31)), world.getLoader().getSprite("ScifiTile"),4, "X"));
		world.register(new Block(new Box(new Vector(-5, 42), new Vector(6, 43)), world.getLoader().getSprite("ScifiTile"),11, "X"));


		Key key1 = new Key(new Vector(47, -2), Key.RED);
		world.register(key1);
		
		Key key2 = new Key(new Vector(-55, 25), Key.BLUE);
		world.register(key2);
		
		Key key3 = new Key(new Vector(-44, -16), Key.GREEN);
		world.register(key3);
		
		Key key4 = new Key(new Vector(16, 35), Key.YELLOW);
		world.register(key4);
		
		Door door1 = new Door(new Box(new Vector(0.5, 16), 3, 3), world.getLoader().getSprite("lock.red"), key1);
		world.register(door1);
		
		Door door2 = new Door(new Box(new Vector(0.5, 21), 3, 3), world.getLoader().getSprite("lock.blue"), key2);
		world.register(door2);
		
		Door door3 = new Door(new Box(new Vector(0.5, 26), 3, 3), world.getLoader().getSprite("lock.green"), key3);
		world.register(door3);
		
		Door door4 = new Door(new Box(new Vector(0.5, 31), 3, 3), world.getLoader().getSprite("lock.yellow"), key4);
		world.register(door4);
		
		world.register(new WoodenBox(new Vector(6.5, 11.5), 1));
		world.register(new WoodenBox(new Vector(6.5, 10.5), 1));
		world.register(new WoodenBox(new Vector(6.5, 9.5), 1));
		world.register(new WoodenBox(new Vector(6.5, 8.5), 1));
		world.register(new WoodenBox(new Vector(7.5, 9.5), 1));
		world.register(new WoodenBox(new Vector(7.5, 10.5), 1));
		world.register(new WoodenBox(new Vector(7.5, 11.5), 1));
		world.register(new WoodenBox(new Vector(8.5, 11.5), 1));
		world.register(new WoodenBox(new Vector(8.5, 10.5), 1));
		world.register(new WoodenBox(new Vector(8.5, 9.5), 1));
		world.register(new WoodenBox(new Vector(7.5, 8.5), 1));
		world.register(new WoodenBox(new Vector(8.5, 8.5), 1));
		
		world.register(new WoodenBox(new Vector(-32.5, -13.5), 1));
		world.register(new WoodenBox(new Vector(-31.5, -13.5), 1));
		world.register(new WoodenBox(new Vector(-32.5, -14.5), 1));
		world.register(new WoodenBox(new Vector(-31.5, -14.5), 1));
		world.register(new WoodenBox(new Vector(-32.5, -15.5), 1));
		world.register(new WoodenBox(new Vector(-31.5, -15.5), 1));
		world.register(new WoodenBox(new Vector(-31.5, -16.5), 1));
		world.register(new WoodenBox(new Vector(-32.5, -16.5), 1));
		world.register(new WoodenBox(new Vector(-31.5, -17.5), 1));
		world.register(new WoodenBox(new Vector(-32.5, -17.5), 1));

		
		world.register(new SawBladeGenerator(new Vector(-35, -10), player, 2, 10));
		world.register(new SawBladeGenerator(new Vector(-37, -10), player, 2, 10));
		world.register(new SawBladeGenerator(new Vector(-39, -10), player, 2, 10));
		world.register(new SawBladeGenerator(new Vector(-41, -10), player, 2, 10));
		
		world.register(new Exit(new Vector(0, 42.5), new LevelTwo(), new Constant(true)));

		world.register(new Jumper(new Vector(-26.5, -11.5)));
				
		world.register(new Block(new Box(new Vector(-9, -4), new Vector(-8, -3)), world.getLoader().getSprite("ScifiTile"),1, "Y"));
		world.register(new Block(new Box(new Vector(-24, -8), new Vector(-23, -7)), world.getLoader().getSprite("ScifiTile"),1, "Y"));

		world.register(new Jumper(new Vector(-2.5, -0.5)));
		world.register(new Block(new Box(new Vector(-3, -2), new Vector(-2, -1)), world.getLoader().getSprite("ScifiTile"),1, "Y"));

		
		world.register(new Block(new Box(new Vector(-4, 5), new Vector(-3, 6)), world.getLoader().getSprite("ScifiTile"),1, "Y"));

		world.register(new Block(new Box(new Vector(-2, -9), new Vector(3, -8)), world.getLoader().getSprite("ScifiTile"),5, "X"));

		world.register(new Jumper(new Vector(12.5, -2.5)));
		world.register(new Jumper(new Vector(4.5, -1.5)));
		
		world.register(new Lava(new Vector(27.5, -11.5)));
		world.register(new Lava(new Vector(27.5, -10.5)));
		world.register(new Lava(new Vector(28.5, -10.5)));
		world.register(new Lava(new Vector(28.5, -11.5)));
		world.register(new Lava(new Vector(30.5, -10.5)));
		world.register(new Lava(new Vector(30.5, -11.5)));
		world.register(new Lava(new Vector(31.5, -10.5)));
		world.register(new Lava(new Vector(31.5, -11.5)));
		
		world.register(new Lava(new Vector(-5.5, 4.5)));
		world.register(new Lava(new Vector(-6.5, 4.5)));
		world.register(new Lava(new Vector(-7.5, 4.5)));
		world.register(new Lava(new Vector(-8.5, 4.5)));
		world.register(new Lava(new Vector(-9.5, 4.5)));
		world.register(new Lava(new Vector(-10.5, 4.5)));
		world.register(new Lava(new Vector(-11.5, 4.5)));
		world.register(new Lava(new Vector(-12.5, 4.5)));
		world.register(new Lava(new Vector(-13.5, 4.5)));
		world.register(new Lava(new Vector(-14.5, 4.5)));
		world.register(new Lava(new Vector(-15.5, 4.5)));
		world.register(new Lava(new Vector(-16.5, 4.5)));
		world.register(new Lava(new Vector(-17.5, 4.5)));
		world.register(new Lava(new Vector(-18.5, 4.5)));
		world.register(new Lava(new Vector(-19.5, 4.5)));
		world.register(new Lava(new Vector(-20.5, 4.5)));
		world.register(new Lava(new Vector(-21.5, 4.5)));
		world.register(new Lava(new Vector(-22.5, 4.5)));
		world.register(new Lava(new Vector(-22.5, 3.5)));
		world.register(new Lava(new Vector(-22.5, 2.5)));
		world.register(new Lava(new Vector(-22.5, 1.5)));
		world.register(new Lava(new Vector(-22.5, 0.5)));
		world.register(new Lava(new Vector(-22.5, -0.5)));
		world.register(new Lava(new Vector(-23.5, -0.5)));
		world.register(new Lava(new Vector(-24.5, -0.5)));
		world.register(new Lava(new Vector(-25.5, -0.5)));
		world.register(new Lava(new Vector(-26.5, -0.5)));
		world.register(new Lava(new Vector(-27.5, -0.5)));
		world.register(new Lava(new Vector(-28.5, -0.5)));
		world.register(new Lava(new Vector(-29.5, -0.5)));
		world.register(new Lava(new Vector(-30.5, -0.5)));
		world.register(new Lava(new Vector(-31.5, -0.5)));
		world.register(new Lava(new Vector(-32.5, -0.5)));
		world.register(new Lava(new Vector(-33.5, -0.5)));
		world.register(new Lava(new Vector(-33.5, -1.5)));
		world.register(new Lava(new Vector(-33.5, -2.5)));
		world.register(new Lava(new Vector(-33.5, -3.5)));
		world.register(new Lava(new Vector(-33.5, -4.5)));
		world.register(new Lava(new Vector(-33.5, -5.5)));
		world.register(new Lava(new Vector(-33.5, -6.5)));
		world.register(new Lava(new Vector(-33.5, -7.5)));
		world.register(new Lava(new Vector(-34.5, -7.5)));
		world.register(new Lava(new Vector(-35.5, -7.5)));
		world.register(new Lava(new Vector(-36.5, -7.5)));
		world.register(new Lava(new Vector(-37.5, -7.5)));
		world.register(new Lava(new Vector(-38.5, -7.5)));
		world.register(new Lava(new Vector(-39.5, -7.5)));
		world.register(new Lava(new Vector(-40.5, -7.5)));
		world.register(new Lava(new Vector(-41.5, -7.5)));
		world.register(new Lava(new Vector(-42.5, -7.5)));
		world.register(new Lava(new Vector(-43.5, -7.5)));
		world.register(new Lava(new Vector(-43.5, -8.5)));
		world.register(new Lava(new Vector(-43.5, -9.5)));
		world.register(new Lava(new Vector(-43.5, -10.5)));
		world.register(new Lava(new Vector(-43.5, -11.5)));
		world.register(new Lava(new Vector(-43.5, -12.5)));
		world.register(new Lava(new Vector(-43.5, -13.5)));
		world.register(new Lava(new Vector(-44.5, -13.5)));
		world.register(new Lava(new Vector(-45.5, -13.5)));

		world.register(new Heart(new Vector(30, -3), 60));
		world.register(new Heart(new Vector(45, -2), 60));
		world.register(new Heart(new Vector(43, -18), 60));

		world.register(new Heart(new Vector(-6, -12), 60));
		world.register(new Heart(new Vector(-5, -23), 60));

		world.register(new Heart(new Vector(15, 37), 60));
		world.register(new Heart(new Vector(54, 20), 60));
		world.register(new Heart(new Vector(15, 10), 60));
		world.register(new Heart(new Vector(9, 18), 60));

		world.register(new Heart(new Vector(-22, 21), 60));
		world.register(new Heart(new Vector(9, 18), 60));
		world.register(new Heart(new Vector(-30, 35), 60));
		world.register(new Heart(new Vector(-63, 46), 60));


		world.register(new Block(new Box(new Vector(45, -16), new Vector(55, -15)), world.getLoader().getSprite("ScifiTile"),10, "X"));
		world.register(new Jumper(new Vector(9.5, 11)));
		
		world.register(new Jumper(new Vector(14, -7.5)));
		
		world.register(new Message(new Vector(7, 4), 2, 2, 6, new Constant(true)));
		world.register(new Message(new Vector(-7, 1), 2.5, 2.5, 7, new Constant(true)));
		world.register(new Message(new Vector(-6, 12), 2, 2.5, 8, new Constant(true)));
		world.register(new Message(new Vector(4.5, 10.5), 3, 2.5, 9, new Constant(true)));
		world.register(new Message(new Vector(38, 3), 10, 2, 10, new Constant(true)));
		world.register(new Message(new Vector(49, -11.5), 8, 0.5, 11, new Constant(true)));
		world.register(new Message(new Vector(23, -16), 3, 0.3, 12, new Constant(true)));
		world.register(new Message(new Vector(8, -15), 4, 1, 2, new Constant(true)));
		world.register(new Message(new Vector(-1, -23), 4, 0.4, 13, new Constant(true)));
		world.register(new Message(new Vector(-18, -26), 6, 0.6, 3, new Constant(true)));
		world.register(new Message(new Vector(-27, 23), 5, 0.3, 14, new Constant(true)));
		world.register(new Message(new Vector(-66.75, 47), 7, 10, 4, new Constant(true)));
		world.register(new Message(new Vector(15, 38.5), 6, 0.5, 5, new Constant(true)));
		world.register(new Message(new Vector(1, 4), 8, 2, 17, new Constant(true)));
		world.register(new Message(new Vector(2, 1.5), 4, 1, 1, new Constant(true)));

		world.register(new Checkpoint(new Vector(52, -13)));
		world.register(new Checkpoint(new Vector(-24, -17)));
		world.register(new Checkpoint(new Vector(-31, 35)));
		world.register(new Checkpoint(new Vector(43, 20)));
		world.register(new Checkpoint(new Vector(1, -1)));
	}
}


