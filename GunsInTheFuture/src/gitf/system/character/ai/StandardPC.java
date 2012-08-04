package gitf.system.character.ai;

import gitf.system.action.responder.IgnoreResponder;
import gitf.system.character.Charac;

public class StandardPC extends IgnoreResponder implements IntelligenceCore
{
	private Charac owner;
	
	public Charac getOwner() {
		return owner;
	}
}
