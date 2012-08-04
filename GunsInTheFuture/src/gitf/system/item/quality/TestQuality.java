package gitf.system.item.quality;

import gitf.system.action.responder.TestResponder;
import gitf.system.item.Item;

public class TestQuality extends TestResponder implements Quality
{
	private Item owner;
	
	public TestQuality(Item owner)
	{
		this.owner = owner;
	}
	
	public Item getOwner() {
		return owner;
	}
}