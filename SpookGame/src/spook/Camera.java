package spook;

import spook.state.GameStateState;
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
	public void tick(GameStateState s) {
		if(a==null)
			return;
		box.setX(a.getLocation().getX() - (int)((double)Game.WIDTH/2.0));
		box.setY(a.getLocation().getY() - (int)((double)Game.HEIGHT/2.0));
	}
	
}
