package gitf.system.character.ai;

import gitf.system.action.Action;
import gitf.system.character.Charac;

public interface IntelligenceCore 
{
	public Charac getOwner();
	public void respondToAction(Action action);
}
