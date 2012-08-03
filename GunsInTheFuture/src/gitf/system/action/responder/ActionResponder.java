package gitf.system.action.responder;

import gitf.system.action.*;
import gitf.system.action.standard.*;

public interface ActionResponder
{
	/**
	 * Responses to the more fundamental Action interfaces,
	 */
	public void respondToAction(Action action);
	public void respondToAction(FreeAction freeAction);
	public void respondToAction(ItemAction itemAction);
	public void respondToAction(MoveAction moveAction);
	public void respondToAction(PersonalAction personalAction);
	public void respondToAction(TargettedAction targettedAction);
	
	/**
	 * Responses to the standard action set.
	 */
	public void respondToAction(EndTurn endTurn);
	public void respondToAction(NewTurn newTurn);
	public void respondToAction(StandardActionRoll standardActionRoll);
	public void respondToAction(StandardAttack standardAttack);
	public void respondToAction(StandardAttributeTest standardAttributeTest);
	public void respondToAction(StandardDrop standardDrop);
	public void respondToAction(StandardMove standardMove);
	public void respondToAction(StandardReload standardReload);
	public void respondToAction(StandardShoot standardShoot);
}
