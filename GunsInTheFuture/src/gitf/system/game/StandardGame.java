package gitf.system.game;

import java.util.ArrayList;

import gitf.gui.GUI;
import gitf.system.character.Charac;
import gitf.system.game.victory.VictoryConditions;
import gitf.system.player.Player;
import gitf.system.map.Map;
import gitf.system.map.TestMap;

public class StandardGame implements Game 
{
	private ArrayList<Player> players;
	private ArrayList<Charac> characters;
	private StandardTurnSequence turnSequence;
	private int gameSpeed = 10; 									// longer is slower (turn speed in ms)
	
	private Map map;
	
	private VictoryConditions victoryConditions;
	
	private Turn currentTurn;
	
	private boolean paused;
	private boolean end;
	
	private int counter = 0;
	
	private String nL = System.getProperty("line.separator");		// the sequence of characters used to 
																	// designate a new line on the host's OS
	
	public StandardGame(ArrayList<Charac> characters)
	{
		this.map = new TestMap();
		this.characters = characters;
		players = new ArrayList<Player>(0);
		for (int i = 0; i < characters.size(); i++)
		{
			characters.get(i).setCurrentArea(map.getAreas().get(0));
			
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
		
		printlnToAll("New game created for : ");
		for (int i = 0; i < characters.size(); i++) printlnToAll(players.get(i).getName());
		printlnToAll();
		
		printlnToAll("Characters (in Aw order) : ");
		ArrayList<Charac> characterSequence = turnSequence.getTurnSequence();
		for (int i = 0; i < characterSequence.size(); i++)
		{
			printlnToAll(characterSequence.get(i).getName());
		}
		
	}
	
	public void start()
	{
		printlnToAll();
		printlnToAll("--- GAME STARTED");
		printlnToAll();
		
		while(end == false)
		{
			printlnToAll("Game turn " + (counter + 1) + " :");
			
			boolean gameTurnComplete = false;
			
			currentTurn = new StandardTurn(this, turnSequence.getFirstCharacter());
			
			while (gameTurnComplete == false && end == false)
			{
				try { Thread.sleep(gameSpeed); }
				catch (InterruptedException ie) { printlnToAll(ie.getMessage()); }
				
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
			
			printlnToAll("--- end of game turn " + (counter));
			printlnToAll();
		}
		
		printlnToAll(victoryConditions.report());
		printlnToAll("Game lasted " + counter + " turns.");
	}
	
	public void pause()
	{
		printlnToAll("The game has been paused.");
		paused = true;
	}
	
	public void stop()
	{
		end = true;
	}
	
	public void printlnToAll()
	{
		printlnToAll("" + nL);
	}
	
	public void printlnToAll(String content)
	{
		ArrayList<GUI> usedGUIs = new ArrayList<GUI>(0);
		
		for (int i = 0; i < players.size(); i++)
		{
			if (usedGUIs.contains(players.get(i).getGUI()))
			{
				
			}
			else
			{
				players.get(i).getGUI().println(content);
				usedGUIs.add(players.get(i).getGUI());
			}
		}
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
	
	public int getGameSpeed() {
		return gameSpeed;
	}
	
	public void setGameSpeed(int gameSpeed) {
		this.gameSpeed = gameSpeed;
	}
}