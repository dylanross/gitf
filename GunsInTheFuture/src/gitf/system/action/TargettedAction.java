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
	 * Core methods.
	 */
	
	public void execute(Charac targetter, Charac targetted);
	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getTargetter();
	public Charac getTargetted();
}