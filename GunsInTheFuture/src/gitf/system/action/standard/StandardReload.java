package gitf.system.action.standard;

import gitf.system.action.ItemAction;
import gitf.system.character.Charac;
import gitf.system.item.Item;

public class StandardReload implements ItemAction
{
	private String name = "Reload";
	private Charac charac;
	private Item item;
	private boolean preAction = true;
	
	/**
	 * Core methods.
	 */
	
	public void execute(Charac charac, Item item) 
	{
		this.charac = charac;
		this.item = item;
	}
	
	public void report()
	{
		System.out.println(this.charac.getName() + " reloaded " + item.getName());
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
	
	public boolean isPreAction() {
		return preAction;
	}
}
