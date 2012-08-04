package gitf.system.character.status.standard;

import java.util.ArrayList;

import gitf.system.action.Action;
import gitf.system.action.standard.NewTurn;
import gitf.system.action.standard.StandardAttack;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.character.Charac;
import gitf.system.character.status.ExclusiveStatus;
import gitf.system.character.status.Status;
import gitf.system.character.status.Down;
import gitf.system.character.status.standard.StandardStance.StanceType;

public class StandardDown extends ExclusiveStatus implements Down
{
	private String name = "Down";
	
	public StandardDown(Charac owner)
	{
		super(owner);
	}
	
	public void respondToAction(Action action)
	{
		if (action instanceof NewTurn)
		{
			int result = new StandardDiceRoll(10).roll();
			if (result <= 2) 
			{
				removeFromOwner();
				System.out.println(getOwner().getName() + " got up!");
			}
			if (result >= 3 && result <= 8); 	// do nothing / stay down
			if (result >= 9)
			{
				new StandardUnconscious(getOwner()).addToOwner();
				removeFromOwner();
				System.out.println(getOwner().getName() + " went from being down to unconscious!");
			}
		}
		
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
	 * This replaces down or stunned statuses.
	 * If owner is dead or unconscious, down status isn't added.
	 */
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
			if (status.get(i) instanceof StandardDown ||
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