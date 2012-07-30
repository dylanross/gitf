package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.item.Item;

/**
 * Interface used by actions which involve only an Item.
 * 
 * @author dylanross
 *
 */
public interface ItemAction extends Action
{
	/**
	 * Core methods.
	 */
	
	public void execute(Item item);		// perform some action using the specified item
	
	/**
	 * Getters / Setters.
	 */
	
	public Item getItem();
}
