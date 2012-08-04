package gitf.system.item;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.responder.ActionResponder;
import gitf.system.item.quality.Quality;

public interface Item extends ActionResponder
{
	public String getName();						// returns the item's name
	public int getHandSlots(); 						// returns the number of HandHeld slots this item takes up when equipped
													// an item which returns 0 does not need to be held to be equipped (e.g. Armour)
	public ArrayList<Quality> getQualities();		// returns a list of the item's qualities
	public void respondToAction(Action action);		// allows the item to respond to actions
	public boolean isNatural();						// returns true if the weapon is part of the owner's body
}