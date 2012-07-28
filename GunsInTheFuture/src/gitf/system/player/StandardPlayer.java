package gitf.system.player;

import java.util.ArrayList;

import gitf.system.game.Game;
import gitf.system.character.Charac;

public class StandardPlayer implements Player
{
	private Game game;
	private ArrayList<Charac> characters;
	
	/**
	 * Getters / Setters.
	 */
	
	public Game getGame() {
		return game;
	}
	public ArrayList<Charac> getCharacters() {
		return characters;
	}
}
