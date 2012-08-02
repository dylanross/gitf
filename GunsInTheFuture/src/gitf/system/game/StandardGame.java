package gitf.system.game;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.player.Player;

public class StandardGame implements Game 
{
	private ArrayList<Player> players;
	private ArrayList<Charac> characters;
	private StandardTurnSequence turnSequence;
	
	private VictoryConditions victoryConditions;
	
	private Turn currentTurn;
	
	private boolean paused;
	private boolean end;
	
	private int counter = 0;
	
	public StandardGame(ArrayList<Charac> characters)
	{
		this.victoryConditions = victoryConditions;
		this.characters = characters;
		players = new ArrayList<Player>(0);
		for (int i = 0; i < characters.size(); i++)
		{
			if (players.contains(characters.get(i).getPlayer()) == false)
			{
				players.add(characters.get(i).getPlayer());
			}
		}
		
		for (int i = 0; i < players.size(); i++)
		{
			players.get(i).setGame(this);
		}
		
		turnSequence = new StandardTurnSequence(characters);
		turnSequence.order();
		
		System.out.println("New game created for : ");
		for (int i = 0; i < characters.size(); i++) System.out.println(players.get(i).getName());
		System.out.println();
		
		System.out.println("Characters (in Aw order) : ");
		ArrayList<Charac> characterSequence = turnSequence.getTurnSequence();
		for (int i = 0; i < characterSequence.size(); i++)
		{
			System.out.println(characterSequence.get(i).getName());
		}
		
	}
	
	public void start()
	{
		System.out.println();
		System.out.println("GAME STARTED");
		
		while(end == false)
		{
			System.out.println();
			System.out.println("Game turn " + (counter + 1) +" :");
			System.out.println();
			
			boolean gameTurnComplete = false;
			
			currentTurn = new StandardTurn(this, turnSequence.getFirstCharacter());
			
			while (gameTurnComplete == false && end == false)
			{
				try { Thread.sleep(100); }
				catch (InterruptedException ie) { System.out.println(ie.getMessage()); }
				
				if (paused == false)
				{
					try
					{
						currentTurn.start();
						currentTurn = new StandardTurn(this, turnSequence.getNextCharacter(currentTurn.getActiveCharac()));
					}
					catch (IndexOutOfBoundsException ioobE)
					{
						gameTurnComplete = true;
					}
					
					if (victoryConditions.areConditionsMet() == true) stop();
				}
				
			}
			
			turnSequence = new StandardTurnSequence(characters);
			turnSequence.order();
			counter++;
			
			System.out.println("--- end of game turn ---");
		}
		
		System.out.println();
		victoryConditions.report();
		System.out.println();
		System.out.println("Game lasted " + counter + " turns.");
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
	
	public VictoryConditions getVictoryConditions() {
		return victoryConditions;
	}
	
	public void setVictoryConditions(VictoryConditions victoryConditions) {
		this.victoryConditions = victoryConditions;
	}
	
	public int getLength() {
		return counter;
	}
}