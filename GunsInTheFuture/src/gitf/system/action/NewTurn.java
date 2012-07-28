package gitf.system.action;

import gitf.system.character.Charac;

/**
 * Action specifying a new game turn has begun.
 * Typical responses are statuses with a duration
 * ticking down and the like.
 * 
 * @author dylanross
 *
 */
public class NewTurn implements PersonalAction, FreeAction
{
	private String name = "New Turn";
	private Charac charac;
	
	public void execute(Charac charac)
	{
		this.charac = charac;
		report();
		charac.respondToAction(this);
	}
	
	public void report() {
		System.out.println("It is " + charac.getName() + "'s turn!");
	}
	
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
