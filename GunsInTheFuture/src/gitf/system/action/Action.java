package gitf.system.action;

/**
 * Interface defining an action 
 * i.e. anything a character (or less commonly a player) can do
 * 
 * @author dylanross
 *
 */
public interface Action 
{
	/**
	 * Core methods.
	 */
	public void report();			// generate a print a report of the action
	public void execute();			// cause the action to happen
	
	/**
	 * Getters / Setters.
	 */
	public String getName();		// returns the name of the action
	public boolean isPreAction();	// returns whether the action is yet to be completed
}