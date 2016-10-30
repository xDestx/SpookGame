package spook.state;

import java.awt.Graphics;

import spook.Game;
import spook.ui.UIButton;

public class MainMenuState extends GameState {

	private UIButton[] buttons;
	
	public MainMenuState(final UIButton[] buttons)
	{
		this.buttons = buttons;
	}
	
	@Override
	public void render(Graphics g) {
		int ydiv = (int)((Game.HEIGHT - Game.HEIGHT*.6)/buttons.length);
		int xdiv = (int)(Game.WIDTH*0.5);
		int xoff = 0;
		int yoff = (int)(Game.HEIGHT*0.3);
		for(int i = 0; i<buttons.length;i++)
		{
			yoff = yoff + (i * ydiv) + (i*5);
			g.fillRect(xoff, yoff, xdiv, ydiv);
		}
	}

	@Override
	public void tick() {
		
	}

	
	
}
