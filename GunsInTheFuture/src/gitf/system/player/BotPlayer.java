package gitf.system.player;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.game.Game;

public class BotPlayer implements Player
{
	private String name = "BOT";
	private Game game;
	private ArrayList<Charac> characters;
	
	public String getName() {
		return name;
	}
	public Game getGame() {
		return game;
	}
	public ArrayList<Charac> getCharacters() {
		return characters;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
}