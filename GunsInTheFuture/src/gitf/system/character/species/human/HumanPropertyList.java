package gitf.system.character.species.human;

import gitf.system.action.Action;
import gitf.system.action.responder.ActionResponder;
import gitf.system.action.responder.ResponderHub;
import gitf.system.character.Charac;
import gitf.system.character.CharacPropertyList;

import java.util.ArrayList;

public class HumanPropertyList<T extends ActionResponder> extends ResponderHub implements CharacPropertyList<T>
{
	private Charac owner;				// the character who owns this HumanPropertyList
	private ArrayList<T> elements;		// the elements contained in the HumanPropertyList
	
	private String nL = System.getProperty("line.separator");	// the sequence of characters used to 
																// designate a new line on the host's OS
	
	/**
	 * One argument (Charac) constructor. Specifies the owning character.
	 */
	public HumanPropertyList(Charac owner)
	{
		this.owner = owner;					// assign owner
		elements = new ArrayList<T>(0);		// create empty element list
	}
	
	/**
	 * Adds an element to the HumanPropertyList.
	 * Will remove any duplicates beforehand.
	 * This means two different Sword references can be in the HumanPropertyList,
	 * but two references to the same Sword cannot. 
	 */
	public void add(T element)
	{
		remove(element);						// remove any previous references to the element
		elements.add(element);					// add reference to the element
	}
	/**
	 * Removes any instances of the specified element from the HumanPropertyList.
	 * Uses pointers to do this.
	 */
	public void remove(T element)
	{
		for (int i = 0; i < elements.size(); i++)					// count through all elements
		{
			if (elements.get(i) == element) elements.remove(i);		// remove references to the specified element
		}
	}
	
	/**
	 * Generates and returns a report of this HumanPropertyList's content.
	 */
	public String report()
	{
		String report = "";																		// form report String stub
		
		if (elements.size() == 0)																// if nothing is in the HumanPropertyList :
		{
			report = "EMPTY";																	// generate appropriate report
		}
		else																					// if elements are in HumanPropertyList
		{
			for (int i = 0; i < elements.size(); i++)											// count through elements
			{
				if (i != elements.size() - 1) report += elements.get(i).toString() + ", " + nL;	// if not last element, add name, comma, and new line
				else report += elements.get(i).toString();										// if last element, add name
			}
		}
		
		return report;																			// return the report
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public Charac getOwner() {
		return owner;
	}
	public ArrayList<T> getContents() {
		return elements;
	}
}