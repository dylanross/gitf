package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.character.Charac;
import gitf.system.character.Inventory;
import gitf.system.item.Item;

public class HumanInventory implements Inventory 
{
	private Charac owner;				// the character who owns this inventory
	private ArrayList<Item> items;		// the items contained in the inventory
	
	private String nL = System.getProperty("line.separator");	// the sequence of characters used to 
																// designate a new line on the host's OS
	
	/**
	 * One argument (Charac) constructor. Specifies the owning character.
	 */
	public HumanInventory(Charac owner)
	{
		this.owner = owner;					// assign owner
		items = new ArrayList<Item>(0);		// create empty item list
	}
	
	/**
	 * Adds an item to the inventory.
	 * Will remove any duplicates beforehand.
	 * This means two different Sword references can be in the inventory,
	 * but two references to the same Sword cannot. 
	 */
	public void add(Item item)
	{
		remove(item);						// remove any previous references to the item
		items.add(item);					// add reference to the item
	}
	/**
	 * Removes any instances of the specified item from the inventory.
	 * Uses pointers to do this.
	 */
	public void remove(Item item)
	{
		for (int i = 0; i < items.size(); i++)				// count through all items
		{
			if (items.get(i) == item) items.remove(i);		// remove references to the specified item
		}
	}
	
	/**
	 * Allows items in the inventory to respond to actions.
	 */
	public void respondToAction(Action action) 
	{
		for (int i = 0; i < items.size(); i++) 				// count through all items 
		{
			items.get(i).respondToAction(action);			// allow each to respond to the action
		}
	}
	
	/**
	 * Generates and returns a report of this inventory's content.
	 */
	public String report()
	{
		String report = "";																	// form report String stub
		
		if (items.size() == 0)																// if nothing is in the inventory :
		{
			report = "INVENTORY EMPTY";														// generate appropriate report
		}
		else																				// if items are in inventory
		{
			for (int i = 0; i < items.size(); i++)											// count through items
			{
				if (i != items.size() - 1) report += items.get(i).getName() + ", " + nL;	// if not last item, add name, comma, and new line
				else report += items.get(i).getName();										// if last item, add name
			}
		}
		
		return report;																		// return the report
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getOwner() {
		return owner;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
}