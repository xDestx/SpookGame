package spook;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import spook.state.GameState;
import spook.state.MainMenuState;
import spook.ui.UIButton;

public class Game {

	private boolean running;
	private Canvas c;
	private JFrame frame;
	private List<GameState>states;
	private int currentState;
	public static final int WIDTH = 16*80, HEIGHT = 9*80;
	
	public Game()
	{
		running = false;
		states = new ArrayList<GameState>();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		frame.setResizable(false);
		c = new Canvas();
		frame.add(c);
	}
	
	public void addState(GameState gs)
	{
		states.add(gs);
	}
	
	public GameState getGameState(int index)
	{
		return this.states.get(index);
	}
	
	public void setGameState(GameState s)
	{
		if(!states.contains(s))
			addState(s);
		currentState = states.indexOf(s);
	}
	
	public void start()
	{
		if(running)
			return;
		running=true;
		//Loop
		init();
		final int nsPerTick = (int)1e9/Game.TPS;
		double timePassed = 0;
		double currentTime = System.nanoTime();
		double lastTime = System.nanoTime();
		
		double nsPassed = 0;
		int ticks = 0;
		int frames = 0;
		while(running)
		{
			currentTime = System.nanoTime();
			nsPassed += currentTime - lastTime;
			timePassed += (currentTime - lastTime)/nsPerTick;
			
			if(timePassed>=1)
			{
				//Tick!!!
				tick();
				timePassed-=1;
				ticks++;
			}
			render();
			frames++;
			
			if(nsPassed > 1e9)
			{
				System.out.println("Ticks: " + ticks + " Frames: " + frames);
				ticks=0;
				frames=0;
				nsPassed=0;
			}
			
			lastTime = currentTime;
		}
	}
	
	private void render()
	{
		BufferStrategy bs = c.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		BufferedImage bi = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		states.get(currentState).render(bi.getGraphics());
		g.drawImage(bi, 0, 0, null);
		g.dispose();
	}
	
	private void tick()
	{
		states.get(currentState).tick();
	}
	
	private void init()
	{
		UIButton b = new UIButton("memes",null);
		UIButton b1 = new UIButton("2222",null);
		UIButton[] list = new UIButton[] { b, b1};
		MainMenuState mms = new MainMenuState(list);
		this.addState(mms);
		this.setGameState(mms);
		frame.setVisible(true);
		if(c.getBufferStrategy() == null)
		{
			c.createBufferStrategy(2);
		}
	}
	
	
	
	
	public static final int TPS = 100;
	
	public static void main(String[] args)
	{
		Game game = new Game();
		
		game.start();
	}
}
