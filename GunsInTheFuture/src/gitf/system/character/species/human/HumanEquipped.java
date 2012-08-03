package gitf.system.character.species.human;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.character.Charac;
import gitf.system.character.Equipped;
import gitf.system.item.Equippable;
import gitf.system.item.HandHeld;

public class HumanEquipped implements Equipped 
{
	private Charac owner;					// the character to whom this Equipped object refers
	private ArrayList<Equippable> items;	// the items that are equipped
	private int handHeldSlots = 2;			// the number of slots for HandHeld items (see HandHeld interface in g.s.item)
											// this is 2 because humans have 2 hands
	private int freeSlots;					// the number of free slots for HandHeld items
	
	private String nL = System.getProperty("line.separator");	// the sequence of characters used to 
																// designate a new line on the host's OS
	
	/**
	 * One argument constructor (Charac). Specifies the owning character.
	 */
	public HumanEquipped(Charac owner)
	{
		this.owner = owner;						// assign owner
		items = new ArrayList<Equippable>(0);	// create empty item list
		cleanUpSlots();							// clean up free slots (equips fists, too)
	}
	
	public void equip(Equippable item)
	{
		if (item instanceof HandHeld)				// if the item is HandHeld :
		{
			HandHeld hhItem = (HandHeld) item;		// cast to HandHeld
			if (hhItem.getSlots() <= freeSlots)		// if there are enough free slots to equip the item :
			{
				remove(item);						// remove any previous references to the item (precaution)
				items.add(item);					// add the item to the equipped items list
				owner.getInventory().remove(item);	// remove the item from the owner's inventory
				cleanUpSlots();						// recalculates the number of free slots available
			}
		}
		else										// if the item is not HandHeld :
		{
			remove(item);							// remove any previous references to the item (precaution)
			items.add(item);						// add the item to the equipped items list
			owner.getInventory().remove(item);		// remove the item from the owner's inventory
		}
	}
	
	/**
	 * Removes any items in the equipped items list with an identical
	 * reference to that of the specified item.
	 */
	private void remove(Equippable item)
	{
		for (int i = 0; i < items.size(); i++)				// count through all items
		{
			if (items.get(i) == item)
			{
				items.remove(i);		// remove references to the specified item
				i--;
			}
		}
	}
	
	/**
	 * Recalculates the number of free slots for HandHeld items.
	 * Equips a HumanFist for each free slot.
	 */
	private void cleanUpSlots()
	{
		freeSlots = handHeldSlots;										// default to maximum free slots
		for (int i = 0; i < items.size(); i++)							// count through items
		{
			if (items.get(i) instanceof HandHeld)						// if the item is HandHeld :
			{
				HandHeld hhItem = (HandHeld) items.get(i);				// cast the item to a HandHeld
				freeSlots = freeSlots - hhItem.getSlots();				// deduct the item's slot value from the number of free slots
			}
			if (items.get(i) instanceof HumanFist)						// if the item is a HumanFist :
			{
				items.remove(i);										// remove the HumanFist
				i--;
			}
		}
		
		for (int i = 0; i < freeSlots; i++) equip(new HumanFist());		// equip a new HumanFist for each empty slot
	}
	
	/**
	 * Removes a specified item from the equipped items list and places
	 * it in the owning character's inventory.
	 */
	public void unequip(Equippable item)
	{
		if (items.remove(item)) owner.getInventory().add(item);		// try to remove the item from equipped list
																	// if successful, add to owner's inventory
		cleanUpSlots();												// reevaluate the number of free slots available
	}
	
	/**
	 * Allows equipped items (and this Equipped item) to respond to actions.
	 */
	public void respondToAction(Action action)
	{
		for (int i = 0; i < items.size(); i++) items.get(i).respondToAction(action);		// count through items and ask for response
	}
	
	/**
	 * Generates and returns a report on the items equipped.
	 */
	public String report()
	{
		String report = "";																	// form report String stub
		
		if (items.size() == 0)																// if nothing is equipped :
		{
			report = "NOTHING EQUIPPED";													// generate appropriate report
		}
		else																				// if items are equipped :
		{
			for (int i = 0; i < items.size(); i++)											// count through items :
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
	public ArrayList<Equippable> getItems() {
		return items;
	}
	public int getHandHeldSlots() {
		return handHeldSlots;
	}
	public int getFreeSlots() {
		return freeSlots;
	}
}