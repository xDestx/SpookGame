package spook.entities;

import spook.GameObject;
import spook.items.Upgrade;
import spook.items.Useable;
import spook.state.GameStateState;
import spook.util.Hitbox;

public class UpgradeEntity extends GameObject {
	private Upgrade up;
	private Hitbox hit;
	public UpgradeEntity(Upgrade u, Hitbox h){
		up = u;
		hit = h;
	}
	public void tick(GameStateState gs) {
		Player p = gs.getPlayer();
		if(p.getHitbox().getBounds().intersects(hit.getBounds())){
			p.handleUpgrade(up);
			gs.removeGameObject(this);
		}

	}
	public Upgrade getUpgrade(){
		return up;
	}
}
