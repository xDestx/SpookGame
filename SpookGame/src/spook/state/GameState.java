package spook.state;

import java.awt.Graphics;

public abstract class GameState {

	
	public GameState()
	{
		
	}
	
	public abstract void render(Graphics g);
	
	public abstract void tick();
	
}
