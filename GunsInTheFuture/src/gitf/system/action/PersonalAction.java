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
	 * Getters / Setters.
	 */
	
	public Charac getCharac();
}
