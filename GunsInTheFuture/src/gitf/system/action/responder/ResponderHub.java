package gitf.system.action.responder;

import java.util.ArrayList;

import gitf.system.action.*;

/**
 * An implementation of ActionResponder for passing Actions to
 * other ActionResponders.
 * 
 * @author dylanross
 *
 */
public abstract class ResponderHub implements ActionResponder 
{
	/**
	 * The ActionResponders that will be passed Actions from this one.
	 */
	private ArrayList<ActionResponder> responders;
	
	/**
	 * Zero argument constructor. Creates a blank responders array.
	 */
	public ResponderHub()
	{
		responders = new ArrayList<ActionResponder>(0);
	}
	
	/**
	 * One argument (ArrayList<ActionResponder>) constructor.
	 * Creates a ResponderHub that will pass to the given responders.
	 * @param responders
	 */
	public ResponderHub(ArrayList<ActionResponder> responders)
	{
		this.responders = responders;
	}
	
	/**
	 * First removes all instances of specified ActionResponder within
	 * the responders list, then adds it to the responders list.
	 * This avoids multiple references to the same ActionResponder.
	 */
	public void addResponder(ActionResponder responder)
	{
		removeResponder(responder);
		responders.add(responder);
	}
	
	/**
	 * Remove all instances of the ActionResponder provided
	 * from the responders list.
	 */
	
	public void removeResponder(ActionResponder responder)
	{
		for (int i = 0; i < responders.size(); i++)
		{
			if (responders.get(i) == responder) responders.remove(i);
		}
	}
	
	/**
	 * Methods for responding to Actions internally.
	 * In most cases these methods should also call the corresponding
	 * passToResponders() method. This is the default behaviour of
	 * the respondToAction() method when extended from this Class.
	 */
	
	public void respondToAction(Action action) {
		passToResponders(action);
	}
	public void respondToAction(AttackAction attackAction) { 
		passToResponders(attackAction);
	}
	public void respondToAction(DiceRollAction diceRollAction) {
		passToResponders(diceRollAction);
	}
	public void respondToAction(ItemAction itemAction) { 
		passToResponders(itemAction);
	}
	public void respondToAction(MoveAction moveAction) { 
		passToResponders(moveAction);
	}
	public void respondToAction(PersonalAction personalAction) { 
		passToResponders(personalAction);
	}
	public void respondToAction(TargettedAction targettedAction) { 
		passToResponders(targettedAction);
	}
	public void respondToAction(TurnAction turnAction) { 
		passToResponders(turnAction);
	}
	
	/**
	 * Methods for passing a given Action (or subtype) to all of the ActionResponders
	 * in the responders list.
	 */
	
	public void passToResponders(Action action) {
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(action);
	}
	public void passToResponders(AttackAction attackAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(attackAction);
	}
	public void passToResponders(DiceRollAction diceRollAction) {
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(diceRollAction);
	}
	public void passToResponders(ItemAction itemAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(itemAction);
	}
	public void passToResponders(MoveAction moveAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(moveAction);
	}
	public void passToResponders(PersonalAction personalAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(personalAction);
	}
	public void passToResponders(TargettedAction targettedAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(targettedAction);
	}
	public void passToResponders(TurnAction turnAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(turnAction);
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public ArrayList<ActionResponder> getResponders() {
		return responders;
	}
	
	public void setResponders(ArrayList<ActionResponder> responders) {
		this.responders = responders;
	}
	
	public void setResponders(ActionResponder responder)
	{
		this.responders = new ArrayList<ActionResponder>(0);
		responders.add(responder);
	}
}