package spook.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

import spook.Camera;
import spook.Game;
import spook.GameObject;
import spook.World;
import spook.graphic.Renderable;
import spook.util.Location;

public class GameStateState extends GameState {

	private Game g;
	private List<GameObject>go;
	private List<Renderable>re;
	private Camera camera;
	private World currentWorld;
	
	public GameStateState(Game g)
	{
		this.g = g;
		go = new LinkedList<GameObject>();
		re = new LinkedList<Renderable>();
		currentWorld = World.getWorld(0);
		camera = new Camera(new Location(0,0,currentWorld), Game.WIDTH, Game.HEIGHT);
	}
	
	public void addObject(GameObject o)
	{
		if(o instanceof Renderable)
		{
			re.add((Renderable)o);
		}
		go.add(o);
	}
	
	public void addRenderable(Renderable r)
	{
		re.add(r);
	}
	
	public void removeRenderable(Renderable r)
	{
		if(re.contains(r))
			re.remove(re.indexOf(r));
	}
	
	public void removeRenederable(int index)
	{
		re.remove(index);
	}
	
	public void removeGameObject(GameObject g)
	{
		if(go.contains(g))
			go.remove(go.indexOf(g));
	}
	
	public void removeGameObject(int index)
	{
		go.remove(index);
	}
	
	@Override
	public void render(Graphics g) {
		try {
			for (Renderable r : re)
			{
				if(camera.intersects(r.getHitbox()))
				{
					int xoff = (int)(r.getHitbox().getBounds().getX() - camera.getHitbox().getBounds().getX());
					int yoff = (int)(r.getHitbox().getBounds().getY() - camera.getHitbox().getBounds().getY());
					r.render(g, xoff, yoff);
				}
			}
		} catch (ConcurrentModificationException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void tick() {
		try {
			for (GameObject g : go)
			{
				g.tick(this);
			}
			camera.tick(this);
		} catch (ConcurrentModificationException e)
		{
			//When you don't want to deal
			e.printStackTrace();
			
			//Continue
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

}
