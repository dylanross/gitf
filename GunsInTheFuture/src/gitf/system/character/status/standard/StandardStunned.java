package gitf.system.character.status.standard;

import gitf.system.action.AttackAction;
import gitf.system.action.TurnAction;
import gitf.system.action.responder.PropertyList;
import gitf.system.character.Charac;
import gitf.system.character.status.Status;
import gitf.system.character.status.Stunned;
import gitf.system.character.status.Dead;
import gitf.system.character.status.Unconscious;
import gitf.system.character.status.Down;

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
	
	/**
	 * Any attacks against a Stunned character get a +2 chance to hit.
	 */
	@Override
	public void respondToAction(AttackAction attackAction)
	{
		if (attackAction.isPreAction())									// if the attack is yet to be performed :
		{
			if (getOwner() == attackAction.getDefender())				// if the owner of this Stunned status is the defender in the attack :
			{
				int toHitChance = attackAction.getToHitChance();		// get the attack's to hit chance
				attackAction.setToHitChance(toHitChance + 2);			// increase hit chance by 3 then set
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
		if (turnAction.isNewTurn()) 									// if the TurnAction wants to start a new turn
		{
			turnsRemaining--;											// reduce number of turns of Stunned remaining
			if (turnsRemaining <= 0)									// if number of turns has been reduced to equal to or less than 0 :
			{
				removeFromOwner();										// remove the stunned status and allow start of the new turn
			}
			else
			{
				turnAction.setNewTurn(false);							// do not allow new turns to start when Stunned
			}
		}
		
		if (! turnAction.isEndTurn()) turnAction.setEndTurn(true);		// ask to end the turn
	}
	
	/**
	 * First, add any previous, leftover stun to this stun, then remove
	 * previous stun and add this stun to owning Charac.
	 */
	public void addToOwner()
	{
		PropertyList<Charac, Status> status = owner.getStatus();
		boolean incapable = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof Dead ||
				status.get(i) instanceof Unconscious ||
				status.get(i) instanceof Down)
			{
				incapable = true;
			}
			if (status.get(i) instanceof Stunned) 
			{
				turnsRemaining += ((StandardStunned) status.get(i)).getTurnsRemaining();
				status.get(i).removeFromOwner();
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