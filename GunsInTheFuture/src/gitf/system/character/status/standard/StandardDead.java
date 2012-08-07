package gitf.system.character.status.standard;

import gitf.system.action.AttackAction;
import gitf.system.action.TurnAction;
import gitf.system.action.responder.PropertyList;
import gitf.system.character.Charac;
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
	 * Any attacks against a Dead character get a +3 chance to hit.
	 */
	@Override
	public void respondToAction(AttackAction attackAction)
	{
		if (attackAction.isPreAction())									// if the attack is yet to be performed :
		{
			if (getOwner() == attackAction.getDefender())				// if the owner of this dead status is the defender in the attack :
			{
				int toHitChance = attackAction.getToHitChance();		// get the attack's to hit chance
				attackAction.setToHitChance(toHitChance + 3);			// increase hit chance by 3 then set
			}
		}
	}
	
	/**
	 * All turn actions are set to deny start of a new turn and 
	 * ask for end of the current turn.
	 */
	@Override
	public void respondToAction(TurnAction turnAction)
	{
		if (turnAction.isNewTurn()) turnAction.setNewTurn(false);		// do not allow new turns to start when dead
		if (! turnAction.isEndTurn()) turnAction.setEndTurn(true);		// ask to end the turn
	}
	
	/**
	 * This replaces down, stunned, or unconscious statuses.
	 * If owner is dead, unconscious status isn't added.
	 */
	public void addToOwner()
	{
		PropertyList<Charac, Status> status = getOwner().getStatus();
		
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof Stance == false)
			{
				status.get(i).removeFromOwner();
				i--;
			}
		}
		
		status.add(this);
		new StandardStance(getOwner(), StanceType.PRONE).addToOwner();
	}
	
	public String getName()
	{
		return name;
	}
}