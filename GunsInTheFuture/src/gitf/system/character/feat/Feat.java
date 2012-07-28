package gitf.system.character.feat;

import gitf.system.action.Action;
import gitf.system.character.Charac;

public interface Feat 
{
	public Charac getOwner();
	public void respondToAction(Action action);
	public void addToOwner();
	public void removeFromOwner();
}