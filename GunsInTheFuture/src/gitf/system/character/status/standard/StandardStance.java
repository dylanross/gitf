package gitf.system.character.status.standard;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.standard.StandardAttack;
import gitf.system.character.Charac;
import gitf.system.character.status.Stance;
import gitf.system.character.status.Status;

public class StandardStance extends ExclusiveStatus implements Stance
{
	public enum StanceType { 
								PRONE, 
								CROUCHED, 
								STANDING;
								
								public String toString()
								{
									switch(this)
									{
										case PRONE :
											return "Prone";
										case CROUCHED :
											return "Crouched";
										case STANDING :
											return "Standing";
										default :
											return null;
									}
								}
						   }
	private StanceType stanceType;
	private String name;
	
	/**
	 * One argument constructor. Creates a StandardStance for the given
	 * Charac, with STANDING StanceType.
	 */
	public StandardStance(Charac owner)
	{
		super(owner);
		this.stanceType = StanceType.STANDING;
	}
	
	/**
	 * Two argument constructor. Creates a StandardStance for the given
	 * Charac, with given StanceType.
	 */
	public StandardStance(Charac owner, StanceType stanceType)
	{
		super(owner);
		this.stanceType = stanceType;
	}
	
	/**
	 * First remove any Statuses of the same Class as this from
	 * the owning Charac's status list, then add this Status.
	 */
	public void addToOwner()
	{
		ArrayList<Status> status = getOwner().getStatus().getContents();
		boolean dead = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof StandardDead) dead = true;
			if (status.get(i) instanceof StandardStance) 
			{
				status.remove(i);
				i--;
			}
		}
		if (dead == false)
		{
			status.add(this);
		}
		else
		{
			status.add(new StandardStance(getOwner(), StanceType.PRONE));
		}
	}
	
	/**
	 * Respond to actions. See individual responses for descriptions.
	 */
	public void respondToAction(Action action)
	{
		if (stanceType.equals(StanceType.PRONE) && action instanceof StandardAttack)
		{
			StandardAttack standardAttackAction = (StandardAttack) action;
			if (standardAttackAction.isPreAction())
			{
				if (getOwner() == standardAttackAction.getAttacker())
				{
					int toHitChance = standardAttackAction.getToHitChance();
					standardAttackAction.setToHitChance(toHitChance - 2);;
				}
				if (getOwner() == standardAttackAction.getDefender())
				{
					int toHitChance = standardAttackAction.getToHitChance();
					standardAttackAction.setToHitChance(toHitChance + 1);
				}
			}
		}
	}
	
	public String getName()
	{
		name = stanceType.toString();
		return name;
	}
}
