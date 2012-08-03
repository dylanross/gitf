package gitf.system.character.status.standard;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.standard.NewTurn;
import gitf.system.action.standard.StandardAttack;
import gitf.system.character.Charac;
import gitf.system.character.status.Status;
import gitf.system.character.status.Unconscious;
import gitf.system.character.status.ExclusiveStatus;
import gitf.system.character.status.standard.StandardStance.StanceType;

public class StandardUnconscious extends ExclusiveStatus implements Unconscious
{
	private String name = "Unconscious";
	
	public StandardUnconscious(Charac owner)
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
		ArrayList<Status> status = getOwner().getStatus();
		boolean incapable = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof StandardDead)
			{
				incapable = true;
			}
			if (status.get(i) instanceof StandardUnconscious || 
				status.get(i) instanceof StandardDown ||
				status.get(i) instanceof StandardStunned)
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
