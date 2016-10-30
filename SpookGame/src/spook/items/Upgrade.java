package spook.items;

import spook.GameObject;

public class Upgrade extends GameObject {
	private char type;
	public Upgrade(char t){
		//M for melee, R for ranged
		type = t;
	}
	@Override
	public void tick() {
		

	}
	public char type(){
		return type;
	}

}
