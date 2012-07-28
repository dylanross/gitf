package gitf.system.player;

import java.util.ArrayList;

import gitf.system.game.Game;
import gitf.system.character.Charac;

public interface Player 
{
	public Game getGame();
	public ArrayList<Charac> getCharacters();
}
