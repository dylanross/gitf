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
	public void report();
	
	/**
	 * Getters / Setters.
	 */
	public String getName();
	public boolean isPreAction();
}
