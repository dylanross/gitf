package gitf.system.item;

import gitf.system.action.responder.PropertyListResponder;
import gitf.system.action.responder.ResponderHub;
import gitf.system.item.quality.Quality;

/**
 * Abstract Class at the base of the concrete Item hierarchy.
 * In general, Items should provide their Qualities as responders.
 * 
 * @author dylanross
 *
 */
public abstract class AbstractItem extends ResponderHub implements Item
{
	private PropertyListResponder<Item, Quality> qualities;
	
	public AbstractItem()
	{
		qualities = new PropertyListResponder<Item, Quality>(this);
		setResponders(qualities);
	}
}