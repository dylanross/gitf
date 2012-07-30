package gitf.system.character.ai;

import gitf.system.action.Action;
import gitf.system.character.Charac;

public class StandardPC implements IntelligenceCore
{
	private Charac owner;
	
	public void respondToAction(Action action) {
		// do nothing
		// will be replaced by player prompts, where appropriate
	}
	
	public Charac getOwner() {
		return owner;
	}
}
