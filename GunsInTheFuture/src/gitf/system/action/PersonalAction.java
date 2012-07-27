package gitf.system.action;

import gitf.system.character.Charac;

public interface PersonalAction extends Action
{
	/**
	 * Core methods.
	 */
	
	public void execute(Charac charac);
	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getCharac();
}
