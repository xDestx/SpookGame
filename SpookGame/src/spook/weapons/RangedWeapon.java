package spook.weapons;

import spook.GameObject;
import spook.items.Upgrade;
import spook.state.GameStateState;

public class RangedWeapon extends GameObject {
	private int dmg;
	private String name;
	private Upgrade[] upgrades;
	public RangedWeapon(String n, int d){
		name = n;
		dmg = d;
		upgrades = new Upgrade[2];
	}
	public void tick(GameStateState gs) {
		

	}
	public int getDmg(){
		return dmg;
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
}
