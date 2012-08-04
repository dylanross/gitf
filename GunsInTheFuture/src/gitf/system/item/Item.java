package gitf.system.item;

import gitf.system.action.responder.ActionResponder;
import gitf.system.action.responder.PropertyListResponder;
import gitf.system.item.quality.Quality;

public interface Item extends ActionResponder
{	
	public String getName();										// returns the item's name
	public int getHandSlots(); 										// returns the number of HandHeld slots this item takes up when equipped
																	// an item which returns 0 does not need to be held to be equipped (e.g. Armour)
	public PropertyListResponder<Item, Quality> getQualities();		// returns a list of the item's qualities
	public boolean isNatural();										// returns true if the weapon is part of the owner's body
}