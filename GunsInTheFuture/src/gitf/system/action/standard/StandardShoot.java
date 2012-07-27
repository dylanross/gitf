package gitf.system.action.standard;

import gitf.system.action.TargettedAction;
import gitf.system.character.Charac;

public class StandardShoot implements TargettedAction
{
	private String name = "Shoot";
	private Charac shooter;
	private Charac target;
	
	public void execute(Charac shooter, Charac target)
	{
		this.shooter = shooter;
		this.target = target;
	}
	
	public String report()
	{
		return shooter.getName() + " shot " + target.getName() + "!";
	}
	
	/**
	 * Getter methods.
	 */
	
	public String getName()
	{
		return name;
	}
	
	public Charac getTargetter()
	{
		return shooter;
	}
	
	public Charac getTargetted()
	{
		return target;
	}
}