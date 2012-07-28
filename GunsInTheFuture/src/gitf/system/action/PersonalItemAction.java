package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.item.Item;

public interface PersonalItemAction extends Action
{
	/**
	 * Core methods.
	 */
	
	public void execute(Charac charac, Item item);
	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getCharac();
	public Item getItem();
}
