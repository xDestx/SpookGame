package spook.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import spook.Game;
import spook.GameObject;
import spook.graphic.Renderable;
import spook.items.Upgrade;
import spook.items.Useable;
import spook.state.GameStateState;
import spook.util.Anchor;
import spook.util.Hitbox;
import spook.util.Location;
import spook.util.Velocity;
import spook.weapons.MeleeWeapon;
import spook.weapons.RangedWeapon;
import spook.world.WorldObject;

public class Player extends GameObject implements Anchor, Renderable {
	private double hp, maxHp, jumpHeight, speed;
	private String name;
	private Hitbox hitbox;
	private Velocity velocity;
	private int hpUpgrades, speedUpgrades, jumpUpgrades;
	private Useable use;
	private MeleeWeapon mw;
	private RangedWeapon rw;

	public Player(String n, Location l) {
		name = n;
		hpUpgrades = 0;
		speedUpgrades = 0;
		jumpUpgrades = 0;
		hp = 100.0;
		maxHp = 100.0;
		speed = 10;
		jumpHeight = 200;
		velocity = new Velocity(0,0);
		hitbox = new Hitbox(70, 70, l);
		use = null;
	}

	public void takeDmg(double dmg) {
		hp -= dmg;
	}

	public double getCurrentHp() {
		return hp;
	}

	public double getMaxHp() {
		return maxHp;
	}

	@Override
	public void tick(GameStateState gs) {
		if (hp <= 0.0) {
			gs.gameOver();
		}
		velocity.addY((double)Game.GRAVITY/(double)Game.TPS);

		for(WorldObject wo: gs.getCurrentWorld().getWorldObjects()){
			if(wo.getHitbox().getBounds().intersects(getBottomBound())){
				velocity.setY(0);
			}
		}

		hitbox.addY(velocity.getY());
		hitbox.addX(velocity.getX());


	}


	public void getHpUp() {
		if (hpUpgrades < 3) {
			hpUpgrades++;
			double temp = maxHp;
			maxHp = maxHp * 1.25;
			hp = hp + (maxHp - temp);
		}
	}

	public void getSpUp() {
		if (speedUpgrades < 3) {
			speedUpgrades++;
			speed *= 1.25;
		}
	}

	public void getJumpUp() {
		if (jumpUpgrades < 3) {
			jumpUpgrades++;
			jumpHeight *= 1.25;
		}
	}

	public Upgrade handleUpgrade(Upgrade touched){
		Upgrade dropped = null;
		if (touched.type() == 'R') {
			return rw.getUpgrade(touched);
		} 
		
		else if (touched.type() == 'M') {
			return mw.getUpgrade(touched);
		} 
		
		else if (touched.type() == 'P') {
			if(touched.subtype() == 'H'){
				getHpUp();
			}
			else if(touched.subtype() == 'J'){
				getJumpUp();
			}
			else{
				getSpUp();
			}
		} 
		return null;
	}

	public Useable getUseable(Useable u) {
		Useable temp = null;
		if (use != null) {
			temp = use;
		}
		use = u;
		return temp;
	}

	@Override
	public void render(Graphics g, int xoff, int yoff) {
		Color last = g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(xoff, yoff, (int)hitbox.getBounds().getWidth(),(int) hitbox.getBounds().getHeight());
	//	drawHitBoxes(g,xoff,yoff);
	}

	@Override
	public Hitbox getHitbox() {
		
		return hitbox;
	}

	@Override
	public Location getLocation() {
		return hitbox.getLocation();
	}
	
	public Rectangle getLeftBound() {
		return new Rectangle((int)hitbox.getLocation().getX(), (int)hitbox.getLocation().getY()+5, 10, (int)this.hitbox.getBounds().getHeight()-10);
	}
	
	public Rectangle getRightBound() {
		return new Rectangle((int)hitbox.getLocation().getX() + (int)(hitbox.getBounds().getWidth()-10), (int)hitbox.getLocation().getY()+5, 10, (int)this.hitbox.getBounds().getHeight()-10);
	}
	
	public Rectangle getTopBound() {
		return new Rectangle((int)hitbox.getLocation().getX()+5, (int)hitbox.getLocation().getY(), (int)(this.hitbox.getBounds().getWidth()-10), 10);
	}
	
	public Rectangle getBottomBound() {
		return new Rectangle((int)hitbox.getLocation().getX()+5, (int)hitbox.getLocation().getY()+(int)(hitbox.getBounds().getHeight()-10), (int)(this.hitbox.getBounds().getWidth()-10), 10);
	}
	
	public void drawHitBoxes(Graphics g, int x, int y)
	{
		g.setColor(Color.ORANGE);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(getLeftBound());
		g2.setColor(Color.RED);
		g2.draw(getRightBound());
		g2.setColor(Color.PINK);
		g2.draw(getTopBound());
		g2.setColor(Color.BLUE);
		g2.draw(getBottomBound());
	}
	
	

}
