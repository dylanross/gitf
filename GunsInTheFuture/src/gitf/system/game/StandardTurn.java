package gitf.system.game;

import gitf.system.action.NewTurn;
import gitf.system.action.EndTurn;
import gitf.system.character.Charac;

public class StandardTurn implements Turn
{
	private Charac activeCharacter;
	private Game game;
	
	public StandardTurn(Game game, Charac activeCharacter)
	{
		this.game = game;
		this.activeCharacter = activeCharacter;
	}
	
	public void start()
	{
		if (activeCharacter.isIncapacitated())
		{
			System.out.println(activeCharacter.getName() + " is incapacitated and can't act this turn!");
			System.out.println();
		}
		else
		{
			activeCharacter.respondToAction(new NewTurn());
		
			boolean endTurn = false;
			
			do
			{
				try { Thread.sleep(2000); }
				catch (InterruptedException ie) { System.out.println(ie.getMessage()); }
				
				System.out.println();
				
				EndTurn endTurnAction = new EndTurn();
				endTurnAction.execute(activeCharacter);
				if (endTurnAction.isEndTurn() || game.getVictoryConditions().areConditionsMet())
				{
					endTurn = true;
					System.out.println();
					System.out.println("--- end of character turn ---");
					System.out.println();
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
