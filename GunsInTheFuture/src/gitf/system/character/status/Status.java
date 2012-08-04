package gitf.system.character.status;

import gitf.system.action.responder.ActionResponder;
import gitf.system.character.Charac;

public interface Status extends ActionResponder
{
	public String getName();
	public Charac getOwner();
	public void addToOwner();
	public void removeFromOwner();
}
