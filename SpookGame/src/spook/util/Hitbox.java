package spook.util;

import java.awt.Rectangle;

import spook.World;

public class Hitbox {

	private Location l;
	private int w, h;
	
	public Hitbox(int w, int h, int x, int y, World world) {
		this.w = w;
		this.h = h;
		l = new Location(x, y, world);
	}
	
	public Hitbox(int w, int h, Location l)
	{
		this.w = w;
		this.h = h;
		this.l = l.clone();
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)l.getX(),(int)l.getY(),w,h);
	}
	
	public void setX(double x)
	{
		this.l.setX(x);
	}
	
	public void setY(double y)
	{
		this.l.setY(y);
	}
	
}
