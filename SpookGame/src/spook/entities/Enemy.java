package spook.entities;

import spook.GameObject;
import spook.items.Upgrade;
import spook.items.Useable;
import spook.state.GameStateState;
import spook.util.Hitbox;
import spook.util.Velocity;

public class Enemy extends GameObject {
	private double hp, maxHp;
	private boolean isBoss;
	private double tickCounter;
	private Hitbox hit;
	public Enemy(double mH, boolean b, Hitbox h){
		maxHp = mH;
		hp = maxHp;
		isBoss = b;
		hit = h;
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
}
