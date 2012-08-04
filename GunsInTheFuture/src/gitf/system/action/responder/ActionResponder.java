package gitf.system.action.responder;

import gitf.system.action.*;

/**
 * Interface for objects which respond to actions.
 * 
 * @author dylanross
 *
 */
public interface ActionResponder 
{
	public void respondToAction(Action action);
	public void respondToAction(AttackAction attackAction);
	// dice roll action
	public void respondToAction(ItemAction itemAction);
	public void respondToAction(MoveAction moveAction);
	public void respondToAction(PersonalAction personalAction);
	public void respondToAction(TargettedAction targettedAction);
	public void respondToAction(TurnAction turnAction);
}