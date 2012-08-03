package gitf.system.action;

import gitf.system.character.Charac;

/**
 * Interface used by actions which involve one character
 * targetting another.
 * 
 * @author dylanross
 *
 */
public interface TargettedAction extends Action
{	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getTargetter();	// the Charac doing the targetting
	public Charac getTargetted();	// the Charac being targetted
}