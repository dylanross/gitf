package gitf.system.character.ai;

import gitf.system.action.responder.ActionResponder;
import gitf.system.character.Charac;

public interface IntelligenceCore extends ActionResponder
{
	public Charac getOwner();
}
