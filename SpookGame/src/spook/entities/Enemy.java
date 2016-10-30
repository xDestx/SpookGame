package spook.entities;

import java.awt.Graphics;

import spook.GameObject;
import spook.graphic.Renderable;
import spook.items.Upgrade;
import spook.items.Useable;
import spook.state.GameStateState;
import spook.util.Hitbox;
import spook.util.ImageLoader;

public class Enemy extends GameObject implements Renderable {
	private double hp, maxHp;
	private boolean isBoss;
	private double tickCounter;
	private Hitbox hit;
	private int costick;
	
	public Enemy(double mH, boolean b, Hitbox h){
		maxHp = mH;
		hp = maxHp;
		isBoss = b;
		hit = h;
		costick = 0;
	}
	public void takeDmg(double dmg) {
		hp-=dmg;
	}
	@Override
	public void tick(GameStateState gs) {
		tickCounter++;
		if(tickCounter%100 == 0 && gs.getPlayer().getHitbox().getBounds().intersects(this.getHitbox().getBounds())){
			gs.getPlayer().takeDmg(20);
		}
		if(hp <= 0.0){
			double chance = (int)(Math.random()*10);
			if(chance == 0){
				int typeChance = (int)(Math.random() * 4);
				char ch = ' ';
				if(typeChance == 0){
					ch = 'D';
				}
				else if (typeChance == 1){
					ch = 'S';
				}
				else if (typeChance == 2){
					ch = 'J';
				}
				else{
					ch = 'H';
				}
				gs.addObject(new UpgradeEntity(new Upgrade(ch), hit));
			}
			else if(chance == 1){
				gs.addObject(new UseableEntity(new Useable('H'), hit));
			}
			gs.removeGameObject(this);
		}
		double xm = gs.getPlayer().getHitbox().getLocation().getX() - this.getHitbox().getLocation().getX();
		double xy = gs.getPlayer().getHitbox().getLocation().getY() - this.getHitbox().getLocation().getY();
		xm = (xm < 0) ? -1:1;
		xy = (xy < 0) ? -1:1;
		this.getHitbox().addX(0.8 * xm);
		this.getHitbox().addY(0.8 * xy);
		this.getHitbox().addY(Math.cos(Math.toRadians(costick)));
		
		costick++;
		if(costick > 360)
			costick = 0;

	}
	public double getCurrentHp(){
		return hp;
	}
	public double getMaxHp(){
		return maxHp;
	}
	public Hitbox getHitbox(){
		return hit;
	}
	@Override
	public void render(Graphics g, int xoff, int yoff) {
		g.drawImage(ImageLoader.getImage("ghost.png"), xoff, yoff, 70,70, null);
	}
}
