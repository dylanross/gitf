package gitf.system.action.standard;

import gitf.system.action.PersonalAction;
import gitf.system.action.ItemAction;
import gitf.system.character.Charac;
import gitf.system.item.Item;

public class StandardDrop implements PersonalAction, ItemAction
{
	private String name = "Drop";
	private String report;
	private boolean preAction = false;
	private int actionCost = 0;
	
	private Charac charac;
	private Item item;
	
	public StandardDrop(Charac charac, Item item)
	{
		this.charac = charac;
		this.item = item;
	}
	
	public void execute()
	{
		report = charac.getName() + " dropped " + item.getName() + "!";
		report();
	}
	
	public void report() {
		charac.getPlayer().getGUI().println(report);
	}
	
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