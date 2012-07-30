package gitf.system.game;

import java.util.ArrayList;

import gitf.system.player.Player;
import gitf.system.character.Charac;
import gitf.system.game.VictoryConditions;

public interface Game 
{
	public ArrayList<Player> getPlayers();
	public ArrayList<Charac> getCharacters();
	public VictoryConditions getVictoryConditions();
	public void setVictoryConditions(VictoryConditions victoryConditions);
	
	public void start();
	public void pause();
	public void stop();
}
