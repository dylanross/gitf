package gitf.system.character.status.standard;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.NewTurn;
import gitf.system.action.standard.StandardAttack;
import gitf.system.character.Charac;
import gitf.system.character.status.Status;
import gitf.system.character.status.Stunned;
import gitf.system.character.status.ExclusiveStatus;
import gitf.system.character.status.standard.StandardStance.StanceType;

public class StandardStunned extends ExclusiveStatus implements Stunned
{
	private String name = "Stunned";
	private Charac owner;
	private int turnsRemaining;
	
	public StandardStunned(Charac owner, int turnsRemaining)
	{
		super(owner);
		this.owner = owner;
		this.turnsRemaining = turnsRemaining;
	}
	
	public void respondToAction(Action action)
	{
		if (action instanceof NewTurn) turnsRemaining--;
		if (turnsRemaining <= 0) removeFromOwner();
	
		if (action instanceof StandardAttack)
		{
			StandardAttack standardAttackAction = (StandardAttack) action;
			if (standardAttackAction.isPreAction())
			{
				if (getOwner() == standardAttackAction.getDefender())
				{
					int toHitChance = standardAttackAction.getToHitChance();
					standardAttackAction.setToHitChance(toHitChance + 2);
				}
			}
		}
	
	}
	
	/**
	 * First, add any previous, leftover stun to this stun, then remove
	 * previous stun and add this stun to owning Charac.
	 */
	public void addToOwner()
	{
		ArrayList<Status> status = owner.getStatus();
		boolean incapable = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof StandardDead ||
				status.get(i) instanceof StandardUnconscious ||
				status.get(i) instanceof StandardDown)
			{
				incapable = true;
			}
			if (status.get(i) instanceof StandardStunned) 
			{
				turnsRemaining += ((StandardStunned) status.get(i)).getTurnsRemaining();
				status.remove(i);
				i--;
			}
		}
		if (incapable == false)
		{
			status.add(this);
		}
	}
	
	public int getTurnsRemaining()
	{
		return turnsRemaining;
	}
	
	public String getName() 
	{
		return name + " (" + turnsRemaining + ") ";
	}
}
