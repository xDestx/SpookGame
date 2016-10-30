package spook.items;

import spook.Game;
import spook.GameObject;
import spook.state.GameStateState;

public class Useable extends GameObject {
	private char type;
	private int duration;

	public Useable(char t, int sec){
		type = t;
		duration = Game.TPS * sec;
	}
	public void tick(GameStateState gs) {
		

	}

}
