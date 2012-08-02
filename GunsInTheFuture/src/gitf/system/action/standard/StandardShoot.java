package gitf.system.action.standard;

import gitf.system.action.TargettedAction;
import gitf.system.action.ItemAction;
import gitf.system.character.Charac;
import gitf.system.item.Item;

public class StandardShoot implements TargettedAction, ItemAction
{
	private String name = "Shoot";
	private Charac shooter;
	private Charac target;
	private Item item;
	private boolean preAction = true;
	
	public StandardShoot(Charac shooter, Charac target, Item item)
	{
		this.shooter = shooter;
		this.target = target;
		this.item = item;
	}
	
	public void execute()
	{
		
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
	
	public Item getItem()
	{
		return item;
	}
	
	public boolean isPreAction() {
		return preAction;
	}
}