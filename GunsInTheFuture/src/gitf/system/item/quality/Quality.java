package gitf.system.item.quality;

import gitf.system.item.Item;
import gitf.system.action.Action;

public interface Quality 
{
	public Item getOwner();
	public void respondToAction(Action action);
}
