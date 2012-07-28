package gitf.system.game;

import java.util.ArrayList;

import gitf.system.player.Player;
import gitf.system.character.Charac;

public interface Game 
{
	public ArrayList<Player> getPlayers();
	public ArrayList<Charac> getCharacters();
	
	public void start();
	public void pause();
	public void stop();
}
