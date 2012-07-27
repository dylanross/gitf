package gitf.system.action;

import gitf.system.character.Charac;
import gitf.system.map.Area;

public interface MoveAction extends Action 
{
	public void execute(Charac mover, Area position, Area destination);
	public Charac getMover();
	public Area getPosition();
	public Area getDestination();
}
