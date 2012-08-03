package gitf.system.item;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.item.quality.Quality;

public interface Item 
{
	public String getName();
	public ArrayList<Quality> getQualities();
	public void respondToAction(Action action);
}