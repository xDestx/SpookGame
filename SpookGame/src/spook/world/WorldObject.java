package spook.world;

import java.awt.Color;
import java.awt.Graphics;

import spook.graphic.Renderable;
import spook.util.Hitbox;
import spook.util.Location;

public class WorldObject implements Renderable {

	private Hitbox bounds;
	private Color c;
	
	public WorldObject(World world, int x, int y, int w, int h, Color c)
	{
		this.c = c;
		bounds = new Hitbox(w, h, new Location(x,y, world));
	}
	
	public Hitbox getHitbox()
	{
		return bounds;
	}

	@Override
	public void render(Graphics g, int xoff, int yoff) {
		Color last = g.getColor();
		g.setColor(c);
		g.fillRect(xoff, yoff, (int)bounds.getBounds().getWidth(), (int)bounds.getBounds().getHeight());
		g.setColor(last);
	}
}
