package gitf.system.character.status;

import gitf.system.action.Action;
import gitf.system.character.Charac;

public interface Status 
{
	public String getName();
	public Charac getOwner();
	public void respondToAction(Action action);
	public void addToOwner();
	public void removeFromOwner();
}
