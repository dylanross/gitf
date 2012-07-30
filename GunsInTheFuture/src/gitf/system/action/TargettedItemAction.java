package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.item.Item;

/**
 * Interface used by actions which involve one character targetting another
 * where there is an Item involved.
 * 
 * e.g. most combat actions.
 * 
 * @author dylanross
 *
 */
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
