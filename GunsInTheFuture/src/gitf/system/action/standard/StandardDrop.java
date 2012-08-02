package gitf.system.action.standard;

import gitf.system.action.PersonalAction;
import gitf.system.action.ItemAction;
import gitf.system.action.FreeAction;
import gitf.system.character.Charac;
import gitf.system.item.Item;

public class StandardDrop implements FreeAction, PersonalAction, ItemAction
{
	private String name = "Drop";
	private Charac charac;
	private Item item;
	private String report;
	
	public StandardDrop(Charac charac, Item item)
	{
		this.charac = charac;
		this.item = item;
	}
	
	public void execute()
	{
		System.out.println(charac.getName() + " dropped " + item.getName() + "!");
		
		report();
	}
	
	public void report() {
		System.out.println(report);
	}
	
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
		return false;
	}
}
