package gitf.system.action;

/**
 * Interface used by actions which convey some message
 * about turn structure. 
 * 
 * e.g. The turn may end, or a new turn is begun.
 * 
 * @author dylanross
 *
 */
public interface TurnAction extends PersonalAction
{
	public boolean isEndTurn();					// if the action wants to end the current turn
	public void setEndTurn(boolean endTurn);	// set whether the action should end the turn
	public boolean isNewTurn();					// if the action wants to start a new turn
	public void setNewTurn(boolean newTurn);	// set whether the action should signify the start of a new turn
}