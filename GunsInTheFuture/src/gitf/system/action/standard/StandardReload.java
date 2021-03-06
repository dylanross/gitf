package gitf.system.action.standard;

import gitf.system.action.PersonalAction;
import gitf.system.action.ItemAction;
import gitf.system.character.Charac;
import gitf.system.item.Item;

public class StandardReload implements PersonalAction, ItemAction
{
	private String name = "Reload";
	private String report;
	private boolean preAction = true;
	private int actionCost;
	
	private Charac charac;
	private Item item;
	
	public StandardReload(Charac charac, Item item)
	{
		this.charac = charac;
		this.item = item;
	}
	
	public void execute() 
	{
		
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
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public boolean isPreAction() {
		return preAction;
	}
	public int getActionCost() {
		return actionCost;
	}
	public void setActionCost(int actionCost) {
		this.actionCost = actionCost;
	}
	
	public Charac getCharac() {
		return charac;
	}
	public Item getItem() {
		return item;
	}
}