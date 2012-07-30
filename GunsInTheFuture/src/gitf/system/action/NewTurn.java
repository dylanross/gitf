package gitf.system.action;

import gitf.system.character.Charac;

/**
 * Action specifying a new game turn has begun.
 * Typical responses are characters rolling for actions and 
 * statuses with a duration ticking down, etc.
 * 
 * @author dylanross
 *
 */
public class NewTurn implements PersonalAction, FreeAction
{
	private String name = "New Turn";			// name of the action
	private Charac charac;						// the character to be notified
	
	/**
	 * Outputs a message saying which character's turn it is,
	 * then allows the character to respond.
	 */
	public void execute(Charac charac)
	{
		this.charac = charac;			// set character to be notified of turn
		report();						// generate report
		charac.respondToAction(this);	// allow character to respond
	}
	
	/**
	 * Generate a report of the action.
	 */
	public void report() {
		System.out.println("It is " + charac.getName() + "'s turn!");
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
		return false;
	}
}