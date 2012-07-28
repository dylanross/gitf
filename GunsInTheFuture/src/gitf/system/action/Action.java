package gitf.system.action;

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
