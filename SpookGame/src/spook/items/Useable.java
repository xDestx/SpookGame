package spook.items;

import spook.Game;
import spook.GameObject;
import spook.state.GameStateState;

public class Useable extends GameObject {
	private char type;

	public Useable(char t){
		type = t;
	}
	public void tick(GameStateState gs) {
		

	}
	public char getType(){
		return type;
	}


}
