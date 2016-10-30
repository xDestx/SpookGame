package spook.entities;

import spook.GameObject;
import spook.items.Upgrade;
import spook.items.Useable;
import spook.state.GameStateState;

public class UseableEntity extends GameObject {
	private Useable use;
	public UseableEntity(Useable u){
		use = u;
	}
	public void tick(GameStateState gs) {
		

	}
	public Useable getUseable(){
		return use;
	}
}
