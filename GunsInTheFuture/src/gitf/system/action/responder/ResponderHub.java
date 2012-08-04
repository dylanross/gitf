package gitf.system.action.responder;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.AttackAction;
import gitf.system.action.FreeAction;
import gitf.system.action.ItemAction;
import gitf.system.action.MoveAction;
import gitf.system.action.PersonalAction;
import gitf.system.action.TargettedAction;

/**
 * An implementation of ActionResponder for passing Actions to
 * other ActionResponders.
 * 
 * @author dylanross
 *
 */
public abstract class ResponderHub implements ActionResponder 
{
	private ArrayList<ActionResponder> responders;
	
	public ResponderHub()
	{
		responders = new ArrayList<ActionResponder>(0);
	}
	
	public ResponderHub(ArrayList<ActionResponder> responders)
	{
		this.responders = responders;
	}
	
	public void addResponder(ActionResponder responder)
	{
		removeResponder(responder);
		responders.add(responder);
	}
	
	public void removeResponder(ActionResponder responder)
	{
		for (int i = 0; i < responders.size(); i++)
		{
			if (responders.get(i) == responder) responders.remove(i);
		}
	}
	
	public ArrayList<ActionResponder> getResponders() {
		return responders;
	}
	
	public void setResponders(ArrayList<ActionResponder> responders) {
		this.responders = responders;
	}
	
	public void respondToAction(Action action) {
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(action);
	}
	public void respondToAction(AttackAction attackAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(attackAction);
	}
	public void respondToAction(FreeAction freeAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(freeAction);
	}
	public void respondToAction(ItemAction itemAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(itemAction);
	}
	public void respondToAction(MoveAction moveAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(moveAction);
	}
	public void respondToAction(PersonalAction personalAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(personalAction);
	}
	public void respondToAction(TargettedAction targettedAction) { 
		for (int i = 0; i < responders.size(); i++) responders.get(i).respondToAction(targettedAction);
	}
}