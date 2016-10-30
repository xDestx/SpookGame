package spook.weapons;

import spook.GameObject;
import spook.items.Upgrade;
import spook.state.GameStateState;

public class MeleeWeapon extends GameObject {
	private int dmg, range;
	private String name;
	private Upgrade[] upgrades;
	public MeleeWeapon(String n, int d, int r){
		name = n;
		dmg = d;
		range = r;
		upgrades = new Upgrade[2];
	}
	public void tick(GameStateState gs) {
		

	}
	public Upgrade getUpgrade(Upgrade newUp){
		Upgrade temp = null;
		if(upgrades[1] != null){
			temp = upgrades[1];
			upgrades[1] = upgrades[0];
			upgrades[0] = newUp;
		}
		else{
			upgrades[1] = upgrades[0];
			upgrades[0] = newUp;
		}
		return temp;
	}
	public int getDmg(){
		return dmg;
	}

}
