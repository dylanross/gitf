package gitf.system.action.standard;

import gitf.system.action.TurnAction;
import gitf.system.character.Charac;

/**
 * Action specifying a new game turn has begun.
 * Typical responses are characters rolling for actions and 
 * statuses with a duration ticking down, etc.
 * 
 * @author dylanross
 *
 */
public class NewTurn implements TurnAction
{
	private String name = "New Turn";			// name of the action
	private String report;
	private boolean preAction;
	private int actionCost = 0;					// this action costs nothing to perform
	
	private Charac charac;						// the character to be notified
	private boolean newTurn = true;				// this action proposes the start of a new turn
	private boolean endTurn = false;			// this action does not propose the end of the current turn
	
	public NewTurn(Charac charac)
	{
		this.charac = charac;
	}
	
	/**
	 * Outputs a message saying which character's turn it is,
	 * then allows the character to respond.
	 */
	public void execute()
	{
		report();								// generate report
		charac.respondToAction(this);			// allow character to respond to NewTurn action
	}
	
	/**
	 * Generate a report of the action.
	 */
	public void report() 
	{
		charac.getPlayer().getGame().printlnToAll("It is " + charac.getName() + "'s turn!");
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