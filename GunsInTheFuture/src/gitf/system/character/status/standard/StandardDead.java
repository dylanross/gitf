package gitf.system.character.status.standard;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.standard.StandardAttack;
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
	
	public void respondToAction(Action action)
	{
		if (action instanceof StandardAttack)
		{
			StandardAttack standardAttackAction = (StandardAttack) action;
			if (standardAttackAction.isPreAction())
			{
				if (getOwner() == standardAttackAction.getDefender())
				{
					int toHitChance = standardAttackAction.getToHitChance();
					standardAttackAction.setToHitChance(toHitChance + 3);
				}
			}
		}
	
	}
	
	/**
	 * This replaces down, stunned, or unconscious statuses.
	 * If owner is dead, unconscious status isn't added.
	 */
	public void addToOwner()
	{
		ArrayList<Status> status = getOwner().getStatus().getContents();
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