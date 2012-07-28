package gitf.system.action.standard;

import gitf.system.action.TargettedAction;
import gitf.system.character.Charac;

public class StandardShoot implements TargettedAction
{
	private String name = "Shoot";
	private Charac shooter;
	private Charac target;
	private boolean preAction = true;
	
	public void execute(Charac shooter, Charac target)
	{
		this.shooter = shooter;
		this.target = target;
	}
	
	public void report()
	{
		System.out.println(shooter.getName() + " shot " + target.getName() + "!");
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
	
	public boolean isPreAction() {
		return preAction;
	}
}