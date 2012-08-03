package gitf.system.action.responder;

import gitf.system.action.*;
import gitf.system.action.standard.*;

/**
 * IgnoreResponder is an implementation of ActionResponder that
 * does absolutely nothing whenever it receives an Action of any sort.
 * 
 * This is very useful as a base for other, more specific ActionResponders
 * since they can then override individual respondToAction() methods based
 * on what type of Action they need to respond to.
 * 
 * It is the base of most ActionResponder implementations in GITF.
 * 
 * IMPORTANT NOTE :
 * At the moment, IgnoreResponder uses a very smelly method called 
 * appropriateResponse(Action action) which chooses a respondToAction() 
 * call appropriate to the type of action. This will be replaced by a nicer 
 * system, possibly using reflection.
 * 
 * @author dylanross
 *
 */
public class IgnoreResponder implements ActionResponder 
{
	/**
	 * Responses to the fundamental Action interfaces.
	 */
	public void respondToAction(Action action) 
	{  
		appropriateResponse(action);
	}
	public void respondToAction(FreeAction freeAction) {  }
	public void respondToAction(ItemAction itemAction) {  }
	public void respondToAction(MoveAction moveAction) {  }
	public void respondToAction(PersonalAction personalAction) {  }
	public void respondToAction(TargettedAction targettedAction) {  }
	
	/**
	 * Responses to the standard action set.
	 */
	public void respondToAction(EndTurn endTurn) {  }
	public void respondToAction(NewTurn newTurn) {  }
	public void respondToAction(StandardActionRoll standardActionRoll) {  }
	public void respondToAction(StandardAttack standardAttack) {  }
	public void respondToAction(StandardAttributeTest standardAttributeTest) {  }
	public void respondToAction(StandardDrop standardDrop) {  }
	public void respondToAction(StandardMove standardMove) {  }
	public void respondToAction(StandardReload standardReload) {  }
	public void respondToAction(StandardShoot standardShoot) {  }
	
	/**
	 * Horrible method for calling the correct method when an Action arrives.
	 * This WILL be replaced by something a bit less smelly, but for now it keeps
	 * all instanceof's in one place.
	 */
	public void appropriateResponse(Action action)
	{
		if (action instanceof FreeAction) respondToAction((FreeAction) action);
		if (action instanceof ItemAction) respondToAction((ItemAction) action);
		if (action instanceof MoveAction) respondToAction((MoveAction) action);
		if (action instanceof PersonalAction) respondToAction((PersonalAction) action);
		if (action instanceof TargettedAction) respondToAction((TargettedAction) action);
		
		if (action instanceof EndTurn) respondToAction((EndTurn) action);
		if (action instanceof NewTurn) respondToAction((NewTurn) action);
		if (action instanceof StandardActionRoll) respondToAction((StandardActionRoll) action);
		if (action instanceof StandardAttack) respondToAction((StandardAttack) action);
		if (action instanceof StandardAttributeTest) respondToAction((StandardAttributeTest) action);
		if (action instanceof StandardDrop) respondToAction((StandardDrop) action);
		if (action instanceof StandardMove) respondToAction((StandardMove) action);
		if (action instanceof StandardReload) respondToAction((StandardReload) action);
		if (action instanceof StandardShoot) respondToAction((StandardShoot) action);
	}
}
