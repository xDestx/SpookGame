package spook.items;

import spook.GameObject;
import spook.state.GameStateState;

public class Upgrade extends GameObject {
	private char type, subtype;
	public Upgrade(char t, char s){
		//M for melee, R for ranged, P for player
		type = t;
		subtype = s;
	}
	public void tick(GameStateState gs) {
		

	}
	public char type(){
		return type;
	}
	public char subtype(){
		return subtype;
	}

}
