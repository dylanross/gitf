package gitf.system.game;

import gitf.system.character.Charac;

public interface Turn 
{
	public Charac getActiveCharac();
	public void start();
}
