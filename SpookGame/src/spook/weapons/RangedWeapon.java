package spook.weapons;

import spook.items.Upgrade;

public class RangedWeapon extends Weapon {
	private int dmg;
	private String name;
	private Upgrade[] upgrades;
	public RangedWeapon(String n, int d){
		name = n;
		dmg = d;
		upgrades = new Upgrade[2];
	}
	public void tick() {
		

	}
	public int getDmg(){
		return dmg;
	}
	public void getUpgrade(Upgrade newUp){
		if(upgrades[1] != null){
			Upgrade temp = upgrades[1];
			upgrades[1] = upgrades[0];
			upgrades[0] = newUp;
		}
		else{
			upgrades[1] = upgrades[0];
			upgrades[0] = newUp;
		}
	}
}
