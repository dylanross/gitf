package gitf.system.game;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.player.Player;

public class StandardGame implements Game 
{
	private ArrayList<Player> players;
	private ArrayList<Charac> characters;
	
	private Turn currentTurn;
	
	private boolean paused;
	private boolean end;
	
	private int counter = 0;
	
	public void start()
	{
		while(end == false)
		{
			try { Thread.sleep(100); }
			catch (InterruptedException ie) { System.out.println(ie.getMessage()); }
			
			if (paused == false)
			{
				currentTurn = new StandardTurn();
				currentTurn.start();
			}
			
			System.out.println("Game counter : " + counter);
			counter++;
		}
	}
	
	public void pause()
	{
		System.out.println("The game has been paused.");
		paused = true;
	}
	
	public void stop()
	{
		end = true;
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public ArrayList<Charac> getCharacters() {
		return characters;
	}
}
