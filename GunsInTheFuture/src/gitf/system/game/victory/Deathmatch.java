package gitf.system.game.victory;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.character.status.Status;
import gitf.system.character.status.Dead;
import gitf.system.character.status.Unconscious;
import gitf.system.game.*;

public class Deathmatch implements VictoryConditions
{
	private Game currentGame;
	private Charac lastManStanding;
	private int numberIncapacitated;
	
	public Deathmatch(Game currentGame)
	{
		this.currentGame = currentGame;
	}
	
	public boolean areConditionsMet()
	{
		numberIncapacitated = 0;
		
		ArrayList<Charac> characters = currentGame.getCharacters();
		
		for (int i = 0; i < characters.size(); i++)
		{
			ArrayList<Status> status = characters.get(i).getStatus().getContents();
			for (int j = 0; j < status.size(); j++)
			{
				if (status.get(j) instanceof Dead ||
					status.get(j) instanceof Unconscious)
				{
					numberIncapacitated++;
					break;
				}
			}
		}
		
		if (numberIncapacitated >= characters.size() - 1)
		{
			for (int i = 0; i < characters.size(); i++)
			{
				if (characters.get(i).isIncapacitated() == false) lastManStanding = characters.get(i);
			}
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void report()
	{
		System.out.println("VICTORY! The last man standing was " + lastManStanding.getName() + " (" + lastManStanding.getPlayer().getName() + ") " +
						   "who defeated " + numberIncapacitated + " enemies.");
	}
}