package gitf.system.character.ai;

import java.util.ArrayList;

import gitf.system.action.TurnAction;
import gitf.system.action.responder.IgnoreResponder;
import gitf.system.action.standard.StandardAttack;
import gitf.system.character.Charac;
import gitf.system.dice.StandardDiceRoll;
import gitf.system.item.Equippable;
import gitf.system.item.standard.ccweapon.CcWeapon;

public class StandardBot extends IgnoreResponder implements IntelligenceCore 
{
	private Charac owner;
	private ArrayList<Charac> gameCharacters;
	
	public StandardBot(Charac owner)
	{
		this.owner = owner;
	}
	
	@Override
	public void respondToAction(TurnAction action) 
	{
		gameCharacters = owner.getPlayer().getGame().getCharacters();
		
		if (action.isEndTurn()) 
		{
			if (owner.getActionsRemaining() > 0)
			{
				action.setEndTurn(false);
				attackRandom();
			}
		}
	}
	
	private void attackRandom()
	{
		Charac randomTarget = gameCharacters.get(new StandardDiceRoll(gameCharacters.size()).roll() - 1);
		
		if (randomTarget != owner)
		{
			ArrayList<Equippable> equippedItems = owner.getEquipped().getItems();
			CcWeapon ccWeapon = null;
			
			for (int i = 0; i < equippedItems.size(); i++)
			{
				if (equippedItems.get(i) instanceof CcWeapon) ccWeapon = (CcWeapon) equippedItems.get(i);
				break;
			}
			
			new StandardAttack(owner, randomTarget, ccWeapon).execute();
		}
		else
		{
			attackRandom();
		}
	}
	
	public Charac getOwner() {
		return owner;
	}
}