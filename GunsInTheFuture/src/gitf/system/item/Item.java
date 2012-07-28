package gitf.system.item;

import gitf.system.action.Action;

public interface Item 
{
	public String getName();
	public void respondToAction(Action action);
}