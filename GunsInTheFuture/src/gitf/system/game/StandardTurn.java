package gitf.system.game;

import gitf.system.action.TurnAction;
import gitf.system.action.standard.EndTurn;
import gitf.system.action.standard.NewTurn;
import gitf.system.character.Charac;

public class StandardTurn implements Turn
{
	private Charac activeCharacter;
	private Game game;
	
	private String nL = System.getProperty("line.separator");		// the sequence of characters used to 
																	// designate a new line on the host's OS
	
	public StandardTurn(Game game, Charac activeCharacter)
	{
		this.game = game;
		this.activeCharacter = activeCharacter;
	}
	
	public void start()
	{
		TurnAction newTurnAction = new NewTurn(activeCharacter);	// create a NewTurn action
		newTurnAction.execute();									// execute the NewTurn action
		
		if (newTurnAction.isNewTurn() == false)						// if the character has refused the new turn :
		{
			game.printlnToAll(activeCharacter.getName() + " is incapacitated and couldn't take their turn!");
			game.printlnToAll();
		}
		else 														// if the character has accepted the new turn :
		{
			boolean endTurn = false;
			
			do
			{
				try { Thread.sleep(game.getGameSpeed()); }
				catch (InterruptedException ie) { System.out.println(ie.getMessage()); }
				
				EndTurn endTurnAction = new EndTurn(activeCharacter);
				endTurnAction.execute();
				if (endTurnAction.isEndTurn() || game.getVictoryConditions().areConditionsMet())
				{
					endTurn = true;
					game.printlnToAll("--- end of character turn");
					game.printlnToAll();
				}
			} 
			while (endTurn == false);
		}
	}
	
	public Charac getActiveCharac()
	{
		return activeCharacter;
	}
}