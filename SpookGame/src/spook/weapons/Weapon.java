package spook.weapons;

import spook.GameObject;
import spook.items.Upgrade;
import spook.state.GameStateState;


public abstract class Weapon extends GameObject {
	
	public abstract void tick(GameStateState gs);
	public abstract int getDmg();
	public abstract void getUpgrade(Upgrade newUp);
}
