package spook.world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class World {

	private final int id;
	private List<WorldObject> wo;
	
	public World(int id)
	{
		this.id = id;
		wo = new ArrayList<WorldObject>();
	}
	
	public List<WorldObject> getWorldObjects()
	{
		return wo;
	}
	
	public void addWorldObject(WorldObject w)
	{
		this.wo.add(w);
	}
	
	public int getId()
	{
		return this.id;
	}
	
	private static List<World> worlds;
	private static boolean initialized = false;
	
	public static void init()
	{
		if(initialized)
			return;
		worlds = new ArrayList<World>();
		
		World world1 = new World(0);
		world1.addWorldObject(new WorldObject(world1, 0,20,100,20, Color.RED));
		
		World world2 = new World(1);
		
		World world3 = new World(2);
		
		worlds.add(world1);
		worlds.add(world2);
		worlds.add(world3);
		initialized = true;
	}
	
	public static World getWorld(int index)
	{
		if(!initialized)
			return null;
		return worlds.get(index);
	}
	
	
}
