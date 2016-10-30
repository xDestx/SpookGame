package spook.weapons;

import spook.items.Upgrade;

public class MeleeWeapon extends Weapon {
	private int dmg, range;
	private String name;
	private Upgrade[] upgrades;
	public MeleeWeapon(String n, int d, int r){
		name = n;
		dmg = d;
		range = r;
		upgrades = new Upgrade[2];
	}
	public void tick() {
		

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
	public int getDmg(){
		return dmg;
	}
}
