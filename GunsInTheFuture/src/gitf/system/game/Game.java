package gitf.system.game;

import java.util.ArrayList;

import gitf.system.player.Player;
import gitf.system.character.Charac;
import gitf.system.game.victory.VictoryConditions;

public interface Game 
{
	public ArrayList<Player> getPlayers();
	public ArrayList<Charac> getCharacters();
	public VictoryConditions getVictoryConditions();
	public void setVictoryConditions(VictoryConditions victoryConditions);
	
	public void start();
	public void pause();
	public void stop();
	
	public int getGameSpeed();
	public void setGameSpeed(int gameSpeed);
	
	public void printlnToAll();
	public void printlnToAll(String content);
}