package gitf.system.character;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.item.Item;

/**
 * Object for keeping track of all non-equipped items in a
 * characters possession.
 * 
 * @author dylanross
 *
 */
public interface Inventory 
{
	public Charac getOwner();						// returns the character to whom this inventory belongs
	public ArrayList<Item> getItems();				// returns all of the items in the inventory
	public void add(Item item);						// adds an item to the inventory
	public void remove(Item item);					// removes an item from the inventory
	public void respondToAction(Action action);		// allows the inventory to respond to external actions
	public String report();							// generates and returns a report of this inventory's content
}