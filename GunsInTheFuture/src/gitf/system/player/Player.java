package gitf.system.player;

import java.util.ArrayList;

import gitf.gui.GUI;
import gitf.system.game.Game;
import gitf.system.character.Charac;

public interface Player 
{
	public String getName();
	public ArrayList<Charac> getCharacters();
	public GUI getGUI();
	public void setGUI(GUI gui);
	public Game getGame();
	public void setGame(Game game);
}
