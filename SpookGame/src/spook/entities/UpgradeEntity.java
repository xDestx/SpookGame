package spook.entities;

import spook.GameObject;
import spook.items.Upgrade;
import spook.items.Useable;
import spook.state.GameStateState;

public class UpgradeEntity extends GameObject {
	private Upgrade up;
	public UpgradeEntity(Upgrade u){
		up = u;
	}
	public void tick(GameStateState gs) {
		

	}
	public Upgrade getUpgrade(){
		return up;
	}
}
