package gitf.system.character;

import gitf.system.item.Equippable;

import java.util.ArrayList;

import gitf.system.action.Action;

/**
 * Object for keeping track of a character's
 * equipped items.
 * 
 * @author dylanross
 *
 */
public interface Equipped
{
	public Charac getOwner();					// returns the character who has these items equipped
	public ArrayList<Equippable> getItems();	// returns all equipped items
	public int getHandHeldSlots();				// returns the maximum number of hand-held item slots (e.g. 2 for humans)
	public int getFreeSlots();					// returns the number of slots for hand-held items remaining (e.g. 1 for human equipped with Sword)	
	public void equip(Equippable item);			// equips an item
	public void unequip(Equippable item);		// unequips an item
	public void respondToAction(Action action); // allows the Equipped object to respond to external Actions.
	public String report();						// generates and returns a report of the equipped items
}