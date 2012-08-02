package gitf.system.action;

import gitf.system.character.Charac;

/**
 * Objects of this Class are used to ask the current Charac
 * whether its turn is over. Generally if the Charac has
 * actions remaining these will be used first.
 * 
 * Used by Turn Objects.
 * 
 * @author dylanross
 *
 */
public class EndTurn implements PersonalAction, FreeAction
{
	public String name = "End Turn";				// name of the action
	private Charac charac;							// the character to query
	
	private boolean preAction;						// whether the action has been performed yet
	
	private boolean endTurn;						// whether the turn should end after execution of this action
	
	public EndTurn(Charac charac)
	{
		this.charac = charac;
	}
	
	/**
	 * Allows the given Charac to decide whether 
	 * to end the current turn.
	 */
	public void execute()
	{
		preAction = true;							// declare that we are pre-action
		endTurn = true;								// default to ending turn
		
		charac.respondToAction(this);				// allow Charac to change the content of this action
		
		preAction = false;							// declare that we are post-action
	}
	
	/**
	 * Generate a report of the action.
	 */
	public void report()
	{
		String reportString;																	// String to describe the decision made by charac
		if (endTurn == true) reportString = "ended the turn";									// set reportString
		else reportString = "did not end the turn";												// set reportString

		System.out.println(charac.getName() + " " + reportString);								// output report
		System.out.println();
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public String getName() {
		return name;
	}
	public Charac getCharac() {
		return charac;
	}
	public boolean isPreAction() {
		return preAction;
	}
	public boolean isEndTurn() {
		return endTurn;
	}
	public void setEndTurn(boolean endTurn) {
		this.endTurn = endTurn;
	}
}