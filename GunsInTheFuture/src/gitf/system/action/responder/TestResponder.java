package gitf.system.action.responder;

import gitf.system.action.*;

/**
 * Used for testing permeation of Actions
 * through the ActionResponder network.
 * 
 * @author dylanross
 *
 */
public class TestResponder implements ActionResponder
{	
	public void respondToAction(Action action) { 
		System.out.println("I was given : " + action.getClass().getName());
	}
	public void respondToAction(AttackAction action) { 
		System.out.println("I was given : " + action.getClass().getName());
	}
	public void respondToAction(ItemAction action) { 
		System.out.println("I was given : " + action.getClass().getName());
	}
	public void respondToAction(MoveAction action) { 
		System.out.println("I was given : " + action.getClass().getName());
	}
	public void respondToAction(PersonalAction action) { 
		System.out.println("I was given : " + action.getClass().getName());
	}
	public void respondToAction(TargettedAction action) { 
		System.out.println("I was given : " + action.getClass().getName());
	}
	public void respondToAction(TurnAction action) { 
		System.out.println("I was given : " + action.getClass().getName());
	}
}