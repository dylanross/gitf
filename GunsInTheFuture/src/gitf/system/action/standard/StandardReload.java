package gitf.system.action.standard;

import gitf.system.action.ItemAction;
import gitf.system.character.Charac;
import gitf.system.item.Item;

public class StandardReload implements ItemAction
{
	private String name = "Reload";
	private Charac charac;
	private Item item;
	
	/**
	 * Core methods.
	 */
	
	public void execute(Charac charac, Item item) 
	{
		this.charac = charac;
		this.item = item;
	}
	
	public String report()
	{
		return this.charac.getName() + " reloaded " + item.getName();
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
	
	public Item getItem() {
		return item;
	}
}
