package gitf.system.action.responder;

import java.util.ArrayList;

public interface PropertyList<OwnerType, ElementType>
{
	public OwnerType getOwner();									// returns the character to whom these Statuses
	public ArrayList<ElementType> getContents();					// returns all of the Statuses contained in this Object
	public void setContents(ArrayList<ElementType> contents);		// returns all of the Statuses contained in this Object
	public void add(ElementType element);							// adds a Status to the set
	public void remove(ElementType element);						// removes a Status from the set
	public void remove(int index);									// removes the Status at the specified index
	public ElementType get(int index);								// returns the element at the index given
	public void set(int index, ElementType element);				// sets the element at the index given
	public int size();												// returns the size of the element array
	public String report();											// generates and returns a report of this Statuses's content
}