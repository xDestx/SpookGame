package spook.entities;

import spook.GameObject;
import spook.state.GameStateState;

public class Character extends GameObject {
	private double hp, maxHp, jumpHeight, speed;
	private String name;
	private int hpUpgrades, speedUpgrades, jumpUpgrades;
	public Character(String n){
		name = n;
		hpUpgrades = 0;
		speedUpgrades = 0;
		jumpUpgrades = 0;
		hp = 100.0;
		maxHp = 100.0;
		speed = 10;
		jumpHeight = 200;
	}
	
	public void takeDmg(double dmg) {
		hp-=dmg;
	}
	public double getCurrentHp(){
		return hp;
	}
	public double getMaxHp(){
		return maxHp;
	}
	@Override
	public void tick(GameStateState gs) {
		if(hp <= 0.0){
			
		}

	}
	public void getHpUp(){
		if(hpUpgrades < 3){
			hpUpgrades++;
			double temp = maxHp;
			maxHp = maxHp * 1.25;
			hp = hp + (maxHp - temp);
		}
	}
	public void getSpUp(){
		if(speedUpgrades < 3){
			speedUpgrades++;
			speed*=1.25;
		}
	}
	public void getJumpUp(){
		if(jumpUpgrades < 3){
			jumpUpgrades++;
			jumpHeight*= 1.25;
		}
	}
	

}
