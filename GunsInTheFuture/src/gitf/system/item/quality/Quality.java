package gitf.system.item.quality;

import gitf.system.item.Item;
import gitf.system.action.responder.ActionResponder;

public interface Quality extends ActionResponder
{
	public Item getOwner();
}
