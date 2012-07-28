package gitf.system.character.status.standard;

import gitf.system.character.Charac;
import gitf.system.character.status.Status;
import gitf.system.character.status.ExclusiveStatus;
import gitf.system.character.status.MovementRestriction;

import java.util.ArrayList;

public class StandardCantRun extends ExclusiveStatus implements MovementRestriction 
{
	private String name = "Can't Run";
	
	public StandardCantRun(Charac owner)
	{
		super(owner);
	}
	
	public void addToOwner()
	{
		ArrayList<Status> status = getOwner().getStatus();
		boolean incapable = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof StandardDead ||
				status.get(i) instanceof StandardCrawlOnly)
			{
				incapable = true;
			}
			if (status.get(i) instanceof StandardCantRun)
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
	
	public String getName()
	{
		return name;
	}
}
