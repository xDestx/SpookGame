package spook.entities;

import spook.GameObject;
import spook.state.GameStateState;

public class Enemy extends GameObject {
	private double hp, maxHp;
	public Enemy(double mH){
		maxHp = mH;
		hp = maxHp;
	}
	public void takeDmg(double dmg) {
		hp-=dmg;
	}
	@Override
	public void tick(GameStateState gs) {
		if(hp <= 0.0){
			
		}

	}
	public double getCurrentHp(){
		return hp;
	}
	public double getMaxHp(){
		return maxHp;
	}

}
