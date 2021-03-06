package gitf.system.action.responder;

import gitf.system.action.*;

/**
 * Abstract implementation of ActionResponder Interface.
 * Extended by Objects which want to make use of the 
 * ActionResponder Interface without declaring a lot of
 * empty methods.
 *
 * @author dylanross
 *
 */
public abstract class IgnoreResponder implements ActionResponder
{
	public void respondToAction(Action action) {  }
	public void respondToAction(AttackAction attackAction) {  }
	public void respondToAction(DiceRollAction diceRollAction) {  }
	public void respondToAction(ItemAction itemAction) {  }
	public void respondToAction(MoveAction moveAction) {  }
	public void respondToAction(PersonalAction personalAction) {  }
	public void respondToAction(TargettedAction targettedAction) {  }
	public void respondToAction(TurnAction turnAction) {  }
}