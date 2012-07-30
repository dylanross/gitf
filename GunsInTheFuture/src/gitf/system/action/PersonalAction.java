package gitf.system.action;

import gitf.system.character.Charac;

/**
 * Interface used by actions which involve only
 * a single character.
 * 
 * @author dylanross
 *
 */
public interface PersonalAction extends Action
{
	/**
	 * Core methods.
	 */
	
	public void execute(Charac charac);		// perform some action using the specified character
	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getCharac();
}
