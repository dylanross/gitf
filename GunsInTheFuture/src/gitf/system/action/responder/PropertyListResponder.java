package gitf.system.action.responder;

import java.util.ArrayList;

public class PropertyListResponder<OwnerType, ElementType extends ActionResponder> extends ResponderHub implements PropertyList<OwnerType, ElementType>
{
	private OwnerType owner;									// the character who owns this PropertyList
	private ArrayList<ElementType> elements;					// the elements contained in the PropertyList
	
	private String nL = System.getProperty("line.separator");	// the sequence of characters used to 
																// designate a new line on the host's OS
	
	/**
	 * One argument (OwnerType) constructor. Specifies the owning Object.
	 */
	public PropertyListResponder(OwnerType owner)
	{
		this.owner = owner;								// assign owner
		elements = new ArrayList<ElementType>(0);		// create empty element list
		updateResponders();
	}
	
	/**
	 * This is needed to keep the list of elements in sync with
	 * the list of responders. Unfortunately they cannot be one
	 * and the same Object. I'm hoping to find a way to make
	 * that possible.
	 * 
	 * For now, this should be used if any modification is made 
	 * via the getContents() or get() methods.
	 */
	private void updateResponders()
	{
		ArrayList<ActionResponder> responders = new ArrayList<ActionResponder>(0);		// create ActionResponder list
		responders.addAll(elements);													// add elements to this list
		setResponders(responders);
	}
	
	/**
	 * Adds an element to the list.
	 * Will remove any duplicate references first.
	 */
	public void add(ElementType element)
	{
		remove(element);						// remove any previous references to the element
		elements.add(element);					// add reference to the element
		updateResponders();
	}
	/**
	 * Removes any instances of the specified element from the list.
	 * Uses pointers to do this.
	 */
	public void remove(ElementType element)
	{
		for (int i = 0; i < elements.size(); i++)					// count through all elements
		{
			if (elements.get(i) == element) elements.remove(i);		// remove references to the specified element
		}
		updateResponders();
	}
	
	/**
	 * Sets the element at the given index. It is better to use add() since this
	 * does not allow duplicate Objects.
	 */
	public void set(int index, ElementType element)
	{
		elements.set(index, element);
		updateResponders();
	}
	
	/**
	 * Gets the element at the given index.
	 */
	public ElementType get(int index)
	{
		return elements.get(index);
	}
	
	/**
	 * Generates and returns a report of this PropertyList's content.
	 */
	public String report()
	{
		String report = "";																			// form report String stub
		
		if (elements.size() == 0)																	// if nothing is in the list :
		{
			report = "EMPTY";																		// generate appropriate report
		}
		else																						// if elements are in list :
		{
			for (int i = 0; i < elements.size(); i++)												// count through elements
			{
				if (i != elements.size() - 1) report += elements.get(i).toString() + ", " + nL;		// if not last element, add name, comma, and new line
				else report += elements.get(i).toString();											// if last element, add name
			}
		}
		
		return report;																				// return the report
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public OwnerType getOwner() {
		return owner;
	}
	public ArrayList<ElementType> getContents() {
		return elements;
	}
	public void setContents(ArrayList<ElementType> elements) {
		this.elements = elements;
		updateResponders();
	}
}
