package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.item.Item;

/**
 * Interface used by actions that involve a character
 * and an item.
 * 
 * @author dylanross
 *
 */
public interface PersonalItemAction extends Action
{
	/**
	 * Core methods.
	 */
	
	public void execute(Charac charac, Item item);		// perform some action using the given character and item
	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getCharac();
	public Item getItem();
}
