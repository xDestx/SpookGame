package spook.weapons;

import spook.GameObject;
import spook.items.Upgrade;


public abstract class Weapon extends GameObject {
	
	public abstract void tick();
	public abstract int getDmg();
	public abstract void getUpgrade(Upgrade newUp);
}
