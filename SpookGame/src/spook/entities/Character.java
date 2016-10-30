package spook.entities;

import spook.GameObject;
import spook.items.Upgrade;
import spook.items.Useable;
import spook.state.GameStateState;
import spook.weapons.MeleeWeapon;
import spook.weapons.RangedWeapon;

public class Character extends GameObject {
	private double hp, maxHp, jumpHeight, speed;
	private String name;
	private int hpUpgrades, speedUpgrades, jumpUpgrades;
	private Useable use;
	private MeleeWeapon mw;
	private RangedWeapon rw;
	public Character(String n){
		name = n;
		hpUpgrades = 0;
		speedUpgrades = 0;
		jumpUpgrades = 0;
		hp = 100.0;
		maxHp = 100.0;
		speed = 10;
		jumpHeight = 200;
		use = null;
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
			gs.gameOver();
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
	
	public void handleUpgrade(Upgrade touched) throws Exception{
		if(touched.type() == 'R'){
			rw.getUpgrade(touched);
		}
		else if(touched.type() == 'M'){
			mw.getUpgrade(touched);
		}
		else if(touched.type() == 'P'){
			
		}
		else{
			throw new Exception();
		}
	}
	public void getUseable(Useable u){
		if(use != null){
			Useable temp = use;
		}
		use = u;
	}

}
