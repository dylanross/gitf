package gitf.system.action.standard;

import gitf.system.action.TurnAction;
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
public class EndTurn implements TurnAction
{
	private String name = "End Turn";				// name of the action
	String report;
	private boolean preAction;						// whether the action has been performed yet
	private int actionCost = 0;						// the cost to perform this action
	
	private Charac charac;							// the character to query
	private boolean newTurn = false;				// this action does not propose the start of a new turn
	private boolean endTurn = true;					// this action proposes the end of the current turn
	
	/**
	 * One argument (Charac) constructor. Specifies the character to whom
	 * this EndTurn action refers.
	 * @param charac
	 */
	public EndTurn(Charac charac)
	{
		this.charac = charac;						// assign charac
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

		charac.getPlayer().getGame().printlnToAll(charac.getName() + " " + reportString);		// output report to everyone
		charac.getPlayer().getGame().printlnToAll();
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public String getName() {
		return name;
	}
	public boolean isPreAction() {
		return preAction;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public int getActionCost() {
		return actionCost;
	}
	public void setActionCost(int actionCost) {
		this.actionCost = actionCost;
	}
	
	public Charac getCharac() {
		return charac;
	}
	public boolean isEndTurn() {
		return endTurn;
	}
	public boolean isNewTurn() {
		return newTurn;
	}
	public void setEndTurn(boolean endTurn) {
		this.endTurn = endTurn;
	}
	public void setNewTurn(boolean newTurn) {
		this.newTurn = newTurn;
	}
}