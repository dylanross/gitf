package gitf.system.character.status.standard;

import java.util.ArrayList;

import gitf.system.character.Charac;
import gitf.system.character.status.ExclusiveStatus;
import gitf.system.character.status.Status;
import gitf.system.character.status.Stance;
import gitf.system.character.status.Dead;
import gitf.system.character.status.standard.StandardStance.StanceType;

public class StandardDead extends ExclusiveStatus implements Dead
{
	public String name = "DEAD";
	
	public StandardDead(Charac owner)
	{
		super(owner);
	}
	
	/**
	 * This replaces down, stunned, or unconscious statuses.
	 * If owner is dead, unconscious status isn't added.
	 */
	public void addToOwner()
	{
		ArrayList<Status> status = getOwner().getStatus();
		boolean incapable = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof Status && status.get(i) instanceof Stance == false)
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