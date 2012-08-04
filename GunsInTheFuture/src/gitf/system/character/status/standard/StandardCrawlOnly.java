package gitf.system.character.status.standard;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.character.status.MovementRestriction;
import gitf.system.character.status.ExclusiveStatus;
import gitf.system.character.status.Status;
import gitf.system.character.status.standard.StandardStance.StanceType;

public class StandardCrawlOnly extends ExclusiveStatus implements MovementRestriction
{
	private String name = "Crawl Only";
	
	public StandardCrawlOnly(Charac owner)
	{
		super(owner);
	}
	
	public void addToOwner()
	{
		ArrayList<Status> status = getOwner().getStatus().getContents();
		boolean incapable = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof StandardDead ||
				status.get(i) instanceof StandardUnconscious)
			{
				incapable = true;
			}
			if (status.get(i) instanceof StandardCrawlOnly ||
				status.get(i) instanceof StandardCantRun)
			{
				status.remove(i);
				i--;
			}
		}
		if (incapable == false)
		{
			status.add(this);
			new StandardStance(getOwner(), StanceType.PRONE).addToOwner();
		}
	}
	
	public String getName()
	{
		return name;
	}
}
