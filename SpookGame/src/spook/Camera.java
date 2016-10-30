package spook;

import spook.util.Anchor;
import spook.util.Hitbox;
import spook.util.Location;

public class Camera extends GameObject {

	private Hitbox box;
	private Anchor a;
	
	public Camera(Location l, int w, int h)
	{
		box = new Hitbox(w,h,l);
	}
	
	public Hitbox getHitbox()
	{
		return box;
	}
	
	public boolean intersects(Hitbox b)
	{
		return b.getBounds().intersects(box.getBounds());
	}

	public void setAnchor(Anchor a)
	{
		this.a = a;
	}
	
	public void removeAnchor()
	{
		a = null;
	}
	
	@Override
	public void tick() {
		if(a==null)
			return;
		box.setX(a.getLocation().getX());
		box.setY(a.getLocation().getY());
	}
	
}
