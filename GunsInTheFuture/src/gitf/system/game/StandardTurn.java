package gitf.system.game;

import gitf.system.character.Charac;

public class StandardTurn implements Turn
{
	private Charac activeCharacter;
	
	public StandardTurn(Charac activeCharacter)
	{
		this.activeCharacter = activeCharacter;
	}
	
	public void start()
	{
		
	}
	
	public Charac getActiveCharac()
	{
		return activeCharacter;
	}
}
