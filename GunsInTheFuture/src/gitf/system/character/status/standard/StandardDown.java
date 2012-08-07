package gitf.system.character.status.standard;

import gitf.system.action.AttackAction;
import gitf.system.action.TurnAction;
import gitf.system.action.responder.PropertyList;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.character.Charac;
import gitf.system.character.status.Status;
import gitf.system.character.status.Down;
import gitf.system.character.status.Dead;
import gitf.system.character.status.Unconscious;
import gitf.system.character.status.Stunned;
import gitf.system.character.status.standard.StandardStance.StanceType;

public class StandardDown extends ExclusiveStatus implements Down
{
	private String name = "Down";
	
	public StandardDown(Charac owner)
	{
		super(owner);
	}
	
	/**
	 * Any attacks against a Down character get a +2 chance to hit.
	 */
	@Override
	public void respondToAction(AttackAction attackAction)
	{
		if (attackAction.isPreAction())									// if the attack is yet to be performed :
		{
			if (getOwner() == attackAction.getDefender())				// if the owner of this dead status is the defender in the attack :
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
		if (turnAction.isNewTurn()) 
		{
			int result = new StandardDiceRoll(10).roll();
			if (result <= 2) 
			{
				removeFromOwner();
				getOwner().getPlayer().getGUI().println(getOwner().getName() + " got up!");
			}
			if (result >= 3 && result <= 8)
			{
				turnAction.setNewTurn(false);							// do not allow new turns to start when Down
			}
			if (result >= 9)
			{
				new StandardUnconscious(getOwner()).addToOwner();
				removeFromOwner();
				getOwner().getPlayer().getGUI().println(getOwner().getName() + " went from being down to unconscious!");
				turnAction.setNewTurn(false);							// do not allow new turns to start when Unconscious
			}
		}
		
		if (! turnAction.isEndTurn()) turnAction.setEndTurn(true);		// ask to end the turn
	}
	
	/**
	 * This replaces down or stunned statuses.
	 * If owner is dead or unconscious, down status isn't added.
	 */
	public void addToOwner()
	{
		PropertyList<Charac, Status> status = getOwner().getStatus();
		boolean incapable = false;
		for (int i = 0; i < status.size(); i++)
		{
			if (status.get(i) instanceof Dead ||
				status.get(i) instanceof Unconscious)
			{
				incapable = true;
			}
			if (status.get(i) instanceof Down ||
				status.get(i) instanceof Stunned)
			{
				status.get(i).removeFromOwner();
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