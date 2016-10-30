package spook.world;

import java.awt.Graphics;

import spook.graphic.Renderable;
import spook.util.Hitbox;
import spook.util.Location;

public class WorldObject implements Renderable {

	private Hitbox bounds;
	
	public WorldObject(World world, int x, int y, int w, int h)
	{
		bounds = new Hitbox(h, w, new Location(x,y, world));
	}
	
	public Hitbox getHitbox()
	{
		return bounds;
	}

	@Override
	public void render(Graphics g, int xoff, int yoff) {
		// TODO Auto-generated method stub
		
	}
}
