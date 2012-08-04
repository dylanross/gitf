package gitf.system.item;

import java.util.ArrayList;

import gitf.system.action.responder.ActionResponder;

public interface ItemPropertyList<T> extends ActionResponder
{
	public Item getOwner();						// returns the character to whom these Statuses
	public ArrayList<T> getContents();			// returns all of the Statuses contained in this Object
	public void add(T element);					// adds a Status to the set
	public void remove(T element);				// removes a Status from the set
	public String report();						// generates and returns a report of this Statuses's content
}
