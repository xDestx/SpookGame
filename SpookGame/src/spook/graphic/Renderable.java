package spook.graphic;

import java.awt.Graphics;

import spook.util.Hitbox;

public interface Renderable {

	public void render(Graphics g, int xoff, int yoff);
	public Hitbox getHitbox();
}
