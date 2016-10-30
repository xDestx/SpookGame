package spook.entities;

import spook.GameObject;
import spook.items.Upgrade;
import spook.items.Useable;
import spook.state.GameStateState;
import spook.util.Hitbox;

public class UseableEntity extends GameObject {
	private Useable use;
	private Hitbox hit;
	public UseableEntity(Useable u, Hitbox h){
		use = u;
		hit = h;
	}
	public void tick(GameStateState gs) {
		Player p = gs.getPlayer();
		if(p.getHitbox().getBounds().intersects(hit.getBounds())){
			p.getUseable(use);
			gs.removeGameObject(this);
		}

	}
	public Useable getUseable(){
		return use;
	}
}
