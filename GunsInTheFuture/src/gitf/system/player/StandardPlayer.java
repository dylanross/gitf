package gitf.system.player;

import java.util.ArrayList;

import gitf.system.game.Game;
import gitf.system.character.Charac;

public class StandardPlayer implements Player
{
	private Game game;
	private ArrayList<Charac> characters;
	private String name;
	
	/**
	 * Getters / Setters.
	 */
	
	public Game getGame() {
		return game;
	}
	public ArrayList<Charac> getCharacters() {
		return characters;
	}
	public String getName() {
		return name;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
}
