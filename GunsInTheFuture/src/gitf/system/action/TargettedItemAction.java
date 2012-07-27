package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.item.Item;

public interface TargettedItemAction extends Action
{
	/**
	 * Core methods.
	 */
	
	public void execute(Charac targetter, Charac targetted, Item item);
	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getTargetter();
	public Charac getTargetted();
	public Item getItem();
}
