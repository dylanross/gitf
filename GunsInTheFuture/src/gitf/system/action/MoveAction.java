package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.map.Area;

/**
 * Interface used by actions which involve character movement.
 * 
 * @author dylanross
 *
 */
public interface MoveAction extends Action 
{
	public Charac getMover();												// returns the character moving
	public Area getOrigin();												// returns the character's original position
	public Area getDestination();											// returns the character's destination position
}