package spook.entities;

import spook.GameObject;
import spook.state.GameStateState;

public class Enemy extends GameObject {
	private double hp, maxHp;
	private boolean isBoss;
	public Enemy(double mH, boolean b){
		maxHp = mH;
		hp = maxHp;
		isBoss = b;
	}
	public void takeDmg(double dmg) {
		hp-=dmg;
	}
	@Override
	public void tick(GameStateState gs) {
		if(hp <= 0.0){
			double chance = (int)(Math.random()*10);
			if(chance < 2){
				//Spawn a random Useable/Upgrade Entity
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
	public void die(){
		if(isBoss){
			
		}
		else{
			
		}
	}
}
