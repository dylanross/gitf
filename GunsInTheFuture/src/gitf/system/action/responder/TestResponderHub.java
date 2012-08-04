package gitf.system.action.responder;

import gitf.system.action.*;

public class TestResponderHub extends ResponderHub
{
	/**
	 * Methods for responding to Actions internally.
	 * In most cases these methods should also call the corresponding
	 * passToResponders() method. This is the default behaviour of
	 * the respondToAction() method when extended from this Class.
	 */
	
	public void respondToAction(Action action) {
		System.out.println("TestResponderHub received : " + action.getClass().getName());
		passToResponders(action);
	}
	public void respondToAction(AttackAction action) { 
		System.out.println("TestResponderHub received : " + action.getClass().getName());
		passToResponders(action);
	}
	public void respondToAction(ItemAction action) { 
		System.out.println("TestResponderHub received : " + action.getClass().getName());
		passToResponders(action);
	}
	public void respondToAction(MoveAction action) { 
		System.out.println("TestResponderHub received : " + action.getClass().getName());
		passToResponders(action);
	}
	public void respondToAction(PersonalAction action) { 
		System.out.println("TestResponderHub received : " + action.getClass().getName());
		passToResponders(action);
	}
	public void respondToAction(TargettedAction action) { 
		System.out.println("TestResponderHub received : " + action.getClass().getName());
		passToResponders(action);
	}
	public void respondToAction(TurnAction action) { 
		System.out.println("TestResponderHub received : " + action.getClass().getName());
		passToResponders(action);
	}
}