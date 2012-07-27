package gitf.system.action;

import gitf.system.character.Charac;

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