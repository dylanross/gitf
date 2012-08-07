package gitf.system.player;

import java.util.ArrayList;

import gitf.gui.GUI;
import gitf.system.character.Charac;
import gitf.system.game.Game;

public class BotPlayer implements Player
{
	private String name = "BOT";
	private ArrayList<Charac> characters;
	private GUI gui;
	private Game game;
	
	public String getName() {
		return name;
	}
	public ArrayList<Charac> getCharacters() {
		return characters;
	}
	public GUI getGUI() {
		return gui;
	}
	public void setGUI(GUI gui) {
		this.gui = gui;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}