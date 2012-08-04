package gitf.system.character.status;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.responder.IgnoreResponder;
import gitf.system.character.Charac;
import gitf.system.character.status.standard.StandardDead;

/**
 * Superclass of any Status that only allows one of its Class to be stored
 * within its owner's status list.
 * 
 * @author dylanross
 *
 */
public class ExclusiveStatus extends IgnoreResponder implements Status
{
	private String name = "ExclusiveStatus";
	private Charac owner;
	
	public ExclusiveStatus()
	{
		
	}
	
	public ExclusiveStatus(Charac owner)
	{
		this.owner = owner;
	}
	
	public void respondToAction(Action action)
	{
		
	}
	
	/**
	 * First remove any Statuses of the same Class as this from
	 * the owning Charac's status list, then add this Status.
	 */
	public void addToOwner()
	{
		ArrayList<Status> status = owner.getStatus().getContents();
		boolean incapable = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof StandardDead) incapable = true;
			if (status.get(i).getClass() == this.getClass()) 
			{
				status.remove(i);
				i--;
			}
		}
		if (incapable == false)
		{
			status.add(this);
		}
	}
	
	/**
	 * Remove this Status from the owning Charac's Status list.
	 */
	public void removeFromOwner()
	{
		ArrayList<Status> status = owner.getStatus().getContents();
		status.remove(this);
	}
	
	public String toString() {
		return getName();
	}
	
	/**
	 * Getters / Setters.
	 */
	
	public String getName()
	{
		return name;
	}
	
	public Charac getOwner()
	{
		return owner;
	}
}
