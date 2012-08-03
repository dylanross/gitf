package gitf.system.item;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.responder.IgnoreResponder;
import gitf.system.item.quality.Quality;

/**
 * Object used by items that respond to actions.
 * Very smelly inheritance. Will likely be replaced.
 * 
 * @author dylanross
 *
 */
public class ItemResponder extends IgnoreResponder 
{
	private Item owner;						// the item to whom this responder refers
	
	/**
	 * One argument (Item) constructor. Specifies ownership.
	 */
	public ItemResponder(Item owner)
	{
		this.owner = owner;					// assign owner
	}
	
	public void respondToAction(Action action)
	{
		ArrayList<Quality> qualities = owner.getQualities();										// retrieve all of the owner item's Qualities
		for (int i = 0; i < qualities.size(); i++) qualities.get(i).respondToAction(action);		// allow each quality to respond in turn
		appropriateResponse(action);																// allow the item itself to respond appropriately
																									// if an item needs this, it should subclass ItemResponder
																									// and specify a more specific respondToAction() method
	}
}
